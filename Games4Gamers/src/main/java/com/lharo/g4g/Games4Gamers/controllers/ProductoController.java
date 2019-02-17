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
import com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto;
import com.lharo.g4g.Games4Gamers.models.Producto;
import com.lharo.g4g.Games4Gamers.services.ProductoService;


@Controller
public class ProductoController {
	
	private ProductoService productoService;

	private final Logger logger = LoggerFactory.getLogger(ProductoController.class);

	Gson gson = new Gson();

	@Autowired(required=true)
	@Qualifier(value="productoService")
	public void setProductoService(ProductoService productoService){
		this.productoService = productoService;
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Producto());
		model.addAttribute("listProduct", this.productoService.listProductos());
		model.addAttribute("listTypeProducts", this.productoService.getCatalogos());
		model.addAttribute("typeProducts", new CatalogoTipoProducto());
		return "product";
	}
	
	@RequestMapping(value= "/product/add", method = RequestMethod.POST)
	public String addProducts(@ModelAttribute("product") Producto p){
		logger.debug("Product " + gson.toJson(p));
		System.out.println(p.toString());
		if(p.getIdProductos() == 0){
			this.productoService.addProduct(p);
		}else{
			this.productoService.updateProducto(p);
		}
		
		return "redirect:/products";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){
		
        this.productoService.deleteProducto(id);
        return "redirect:/products";
    }
 
    @RequestMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.productoService.getProductoById(id));
        model.addAttribute("listProduct", this.productoService.listProductos());
        return "product";
    }
	
}