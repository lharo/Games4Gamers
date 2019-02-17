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
import com.lharo.g4g.Games4Gamers.models.Proveedor;
import com.lharo.g4g.Games4Gamers.services.ProveedorService;

@Controller
public class ProveedorController {

	private ProveedorService proveedorService; 
	
	private final Logger logger = LoggerFactory.getLogger(ProveedorController.class);

	Gson gson = new Gson();

	@Autowired(required=true)
	@Qualifier(value="proveedorService")
	public void setProveedorService(ProveedorService proveedorService){
		this.proveedorService = proveedorService;
	}
	
	@RequestMapping(value = "/proveedor", method = RequestMethod.GET)
	public String listProveedores(Model model) {
		model.addAttribute("proveedor", new Proveedor());
		model.addAttribute("listProveedores", this.proveedorService.getProveedores());
		return "proveedor";
	}
	
	@RequestMapping(value= "/proveedor/add", method = RequestMethod.POST)
	public String addProveedor(@ModelAttribute("proveedor") Proveedor p){
		logger.debug("Proveedor " + gson.toJson(p));
		System.out.println(p.toString());
		if(p.getIdProveedores() == 0){
			this.proveedorService.addProveedor(p);
		}else{
			this.proveedorService.updateProveedor(p);
		}
		
		return "redirect:/proveedor";
		
	}
	
	@RequestMapping("/removeProveedor/{id}")
    public String removeProveedor(@PathVariable("id") int id){
		
        this.proveedorService.deleteProveedor(id);
        return "redirect:/proveedor";
    }
 
    @RequestMapping("/editProveedor/{id}")
    public String editProveedor(@PathVariable("id") int id, Model model){
        model.addAttribute("proveedor", this.proveedorService.getProveedorById(id));
        model.addAttribute("listProveedores", this.proveedorService.getProveedores());
        return "proveedor";
    }

}
