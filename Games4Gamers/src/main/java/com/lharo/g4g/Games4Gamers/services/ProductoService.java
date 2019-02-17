package com.lharo.g4g.Games4Gamers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lharo.g4g.Games4Gamers.daos.ProductoDao;
import com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto;
import com.lharo.g4g.Games4Gamers.models.Producto;

@Service
public class ProductoService {
	private ProductoDao productoDao;

	public ProductoDao getProductoDao() {
		return productoDao;
	}

	public void setProductoDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}
	
	@Transactional
	public void addProduct(Producto p) {
		//p.setIdProductos(this.productoDao.getMaxId());
		this.productoDao.create(p);
	}
	
	@Transactional
	public void updateProducto(Producto p) {
		this.productoDao.update(p);
	}
	
	@Transactional
	public List<Producto> listProductos() {
		List<Producto> pList = new ArrayList<Producto>();
		for(Producto e : this.productoDao.listAll()) {
			pList.add(e);
		}
		return pList;
	}
	
	@Transactional
	public Producto getProductoById(int id) {
		return this.productoDao.getById(id);
	}

	@Transactional
	public void deleteProducto(int id) {
		this.productoDao.delete(id);
	}
	
	@Transactional
	public List<CatalogoTipoProducto> getCatalogos(){
		return this.productoDao.listAllCatalogs();
	}
	
}
