package com.lharo.g4g.Games4Gamers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto;
import com.lharo.g4g.Games4Gamers.models.Proveedor;
import com.lharo.g4g.Games4Gamers.services.ProductoService;

@Controller
public class StaticController {
	
	private ProductoService productoService;

	@Autowired(required=true)
	@Qualifier(value="productoService")
	public void setProductoService(ProductoService productoService){
		this.productoService = productoService;
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
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String listProductos(Model model) {
    	model.addAttribute("mapProduct", this.productoService.getProductHashMap());
		return "dashboard";
	}
}




