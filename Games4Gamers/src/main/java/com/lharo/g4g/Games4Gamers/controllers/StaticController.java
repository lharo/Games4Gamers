package com.lharo.g4g.Games4Gamers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto;
import com.lharo.g4g.Games4Gamers.models.Producto;
import com.lharo.g4g.Games4Gamers.services.MailService;
import com.lharo.g4g.Games4Gamers.services.ProductoService;
import com.lharo.g4g.Games4Gamers.util.Mail;
import com.lharo.g4g.Games4Gamers.util.MailUtil;
import com.lharo.g4g.Games4Gamers.util.User;

@Controller
public class StaticController {
	
	private ProductoService productoService;
	private MailService mailService;
	
	@Autowired(required=true)
	@Qualifier(value="productoService")
	public void setProductoService(ProductoService productoService){
		this.productoService = productoService;
	}

	@Autowired(required=true)
	@Qualifier(value="mailService")
	public void setMailService(MailService mailService){
		this.mailService = mailService;
	}

	
	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public String enterManagement(Model model) {
		return "management";
	}
	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public String enterStore(Model model) {
		model.addAttribute("listProduct", this.productoService.listProductos());
		return "store";
	}
   @RequestMapping("/orderProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
    	model.addAttribute("product", this.productoService.getProductoById(id));
        return "orderProduct";
    }
   @RequestMapping("/orderProductBought/{id}/{quantity}")
   public String buyProduct(@PathVariable("id") int id, @PathVariable("quantity") int quantity ,Model model){
   		this.productoService.buyProduct(id, quantity);
	   return "redirect:/store";   
   	}
   @RequestMapping("/reporting")
   public String generateReports(Model model){
	   return "report";
   	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String listProductos(Model model) {
    	model.addAttribute("mapProduct", this.productoService.getProductHashMap());
		return "dashboard";
	}
	
	@RequestMapping(value = "/")
	public String listProducts(Model model) {
		model.addAttribute("usuario", new User());
		return "logIn";
	}
	
	@RequestMapping("/mailForm/{id}")
	public String sendMail(@PathVariable("id") int id, Model model){
		model.addAttribute("type", id);
		model.addAttribute("mail", new Mail());
		return "mailForm";
	}
	
	@RequestMapping("mailForm/sendMail")
	public String sendMail(@ModelAttribute("mail") Mail m){
		Gson gson = new Gson();
		System.out.println(gson.toJson(m));
		MailUtil mailUtil = new MailUtil();
		if(mailUtil.sendMail(m.getReceivers(), m.getMsg(), m.getSubject())) return "report";
		else return "mailForm";
	}
}





