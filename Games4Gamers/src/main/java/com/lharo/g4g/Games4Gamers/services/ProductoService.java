package com.lharo.g4g.Games4Gamers.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.lharo.g4g.Games4Gamers.daos.ProductoDao;
import com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto;
import com.lharo.g4g.Games4Gamers.models.Producto;
import com.lharo.g4g.Games4Gamers.models.Proveedor;

@Service
public class ProductoService {
	
	private ProductoDao productoDao;
	public Gson gson = new Gson();
	
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
	
	@Transactional
	public List<Proveedor> getProveedores(){
		return this.productoDao.listAllProveedores();
	}

	@Transactional
	public void buyProduct(int id, int quantity) {
		this.productoDao.buyProduct(id, quantity);
	}

	@Transactional
	public String getProductHashMap() {
		// TODO Auto-generated method stub
		Map<Object, Object> map = null;
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();

		List<Producto> listP = listProductos();
		
		for( Producto l : listP) {
			map = new HashMap<Object, Object>();
			map.put("label", l.getNombre());
			map.put("y", l.getVentasTotales());
			list.add(map);
		}
		String prods = gson.toJson(list);
		System.out.println("Prods:" + prods);
		return prods;
	}
	
}
