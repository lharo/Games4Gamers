package com.lharo.g4g.Games4Gamers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lharo.g4g.Games4Gamers.daos.CatalogoTipoProductoDao;
import com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto;

@Service
public class CatalogoTipoProductoService {
	private CatalogoTipoProductoDao catalogoTipoProducto;

	public CatalogoTipoProductoDao getCatalogoTipoProductoDao() {
		return catalogoTipoProducto;
	}

	public void setCatalogoTipoProductoDao(CatalogoTipoProductoDao catalogoTipoProducto) {
		this.catalogoTipoProducto = catalogoTipoProducto;
	}
	
	@Transactional
	public void addCatalogoTipoProducto(CatalogoTipoProducto p) {
		//p.setIdProductos(this.productoDao.getMaxId());
		this.catalogoTipoProducto.create(p);
	}
	
	@Transactional
	public void updateCatalogoTipoProducto(CatalogoTipoProducto p) {
		this.catalogoTipoProducto.update(p);
	}
	
	@Transactional
	public List<CatalogoTipoProducto> listCatalogoTipoProducto() {
		List<CatalogoTipoProducto> pList = new ArrayList<CatalogoTipoProducto>();
		for(CatalogoTipoProducto e : this.catalogoTipoProducto.listAllCatalogs()) {
			pList.add(e);
		}
		return pList;
	}
	
	@Transactional
	public CatalogoTipoProducto getCatalogoTipoProductoById(int id) {
		return this.catalogoTipoProducto.getById(id);
	}

	@Transactional
	public void deleteCatalogoTipoProducto(int id) {
		this.catalogoTipoProducto.delete(id);
	}
	
}
