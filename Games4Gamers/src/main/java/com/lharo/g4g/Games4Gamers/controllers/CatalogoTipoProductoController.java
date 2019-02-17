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
import com.lharo.g4g.Games4Gamers.services.CatalogoTipoProductoService;

@Controller
public class CatalogoTipoProductoController {
	private CatalogoTipoProductoService catalogoTipoProductoService;

	private final Logger logger = LoggerFactory.getLogger(CatalogoTipoProductoController.class);

	Gson gson = new Gson();

	@Autowired(required=true)
	@Qualifier(value="catalogoTipoProductoService")
	public void setCatalogoTipoProductoService(CatalogoTipoProductoService catalogoTipoProductoService){
		this.catalogoTipoProductoService = catalogoTipoProductoService;
	}
	
	@RequestMapping(value = "/tipoProducto", method = RequestMethod.GET)
	public String listCatalogoTipoProducto(Model model) {
		model.addAttribute("typeProducts", new CatalogoTipoProducto());
		model.addAttribute("listTypeProducts", this.catalogoTipoProductoService.listCatalogoTipoProducto());
		return "tipoProducto";
	}
	
	@RequestMapping(value= "/tipoProducto/add", method = RequestMethod.POST)
	public String addCatalogoTipoProducto(@ModelAttribute("typeProducts") CatalogoTipoProducto p){
		logger.debug("CatalogoTipoProducto " + gson.toJson(p));
		System.out.println(p.toString());
		if(p.getIdTipoProducto() == 0){
			this.catalogoTipoProductoService.addCatalogoTipoProducto(p);
		}else{
			this.catalogoTipoProductoService.updateCatalogoTipoProducto(p);
		}
		
		return "redirect:/tipoProducto";
		
	}
	
	@RequestMapping("/removeTipoProducto/{id}")
    public String removeCatalogoTipoProducto(@PathVariable("id") int id){
		
        this.catalogoTipoProductoService.deleteCatalogoTipoProducto(id);
        return "redirect:/tipoProducto";
    }
 
    @RequestMapping("/editTipoProducto/{id}")
    public String editCatalogoTipoProducto(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.catalogoTipoProductoService.getCatalogoTipoProductoById(id));
        model.addAttribute("listProduct", this.catalogoTipoProductoService.listCatalogoTipoProducto());
        return "tipoProducto";
    }
}
