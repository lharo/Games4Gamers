package com.lharo.g4g.Games4Gamers.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.lharo.g4g.Games4Gamers.models.Usuarios;
import com.lharo.g4g.Games4Gamers.services.UserService;
import com.lharo.g4g.Games4Gamers.util.User;

@Controller
public class UsuarioController {
	
	private UserService usuarioService;

	private final Logger logger = LoggerFactory.getLogger(ProductoController.class);

	Gson gson = new Gson();

	@Autowired(required=true)
	@Qualifier(value="usuarioService")
	public void setUsuarioService(UserService usuarioService){
		this.usuarioService = usuarioService;
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String reload(Model model) {
		model.addAttribute("user", new Usuarios());
		return "registration";
	}
	
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") Usuarios u){
		logger.debug("User " + gson.toJson(u));
		u.setRol(2);
		u.setContrasenia(com.lharo.g4g.Games4Gamers.util.Utility.digestStr(u.getContrasenia()));
		System.out.println(u.toString());
		if(u.getIdUsuario() == 0){
			this.usuarioService.addUser(u);
		}else{
			this.usuarioService.updateUser(u);
		}
		//setUser
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/removeUser/{id}")
    public String removeProduct(@PathVariable("id") int id){
		
        this.usuarioService.deleteUser(id);
        return "redirect:/";
    }
 
    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
	 	model.addAttribute("product", this.usuarioService.getUserById(id));
        return "/";
    }
	
    @RequestMapping(value= "/logIn/enter", method = RequestMethod.POST)
	public String validateUser(@ModelAttribute("usuario") User u){				
		
    	if(this.usuarioService.validateUser(u)) {
			return "management";		
		}
		else return "logIn";
	}
}
