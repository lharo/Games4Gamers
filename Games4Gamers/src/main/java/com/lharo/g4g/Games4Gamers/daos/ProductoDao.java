package com.lharo.g4g.Games4Gamers.daos;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.lharo.g4g.Games4Gamers.entities.GenericDaoImpl;
import com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto;
import com.lharo.g4g.Games4Gamers.models.DetallesOrden;
import com.lharo.g4g.Games4Gamers.models.Producto;
import com.lharo.g4g.Games4Gamers.models.Proveedor;

@Repository
public class ProductoDao extends GenericDaoImpl{

	public Producto getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Producto p = (Producto) session.load(Producto.class, new Integer(id));
		logger.info("Producto loaded successfully, details=" + p);
		return p;

	}

	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Producto p = (Producto) session.load(Producto.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Producto deleted successfully, Product details=" + p);
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> listAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Producto> eList = session.createQuery("from Producto").list();
		for(Producto e : eList){
			logger.info("Producto List::"+ e);
		}
		return eList;

	}

	public void create(Producto p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Product saved successfully, Product Details=" + p);		
	}

	public void update(Producto p) {

		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Product updated successfully, Product Details=" + p);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<CatalogoTipoProducto> listAllCatalogs() {
		Session session = this.sessionFactory.getCurrentSession();
		List<CatalogoTipoProducto> eList = session.createQuery("from CatalogoTipoProducto").list();
		for(CatalogoTipoProducto e : eList){
			logger.debug("CatalogoTipoProducto List::"+ e);
		}
		return eList;
	}

	public List<Proveedor> listAllProveedores() {

		Session session = this.sessionFactory.getCurrentSession();
		List<Proveedor> eList = session.createQuery("from Proveedor").list();
		for(Proveedor e : eList){
			logger.info("Proveedor List::"+ e);
		}
		return eList;

	}

	public void buyProduct(int id, int quantity) {
		Session session = this.sessionFactory.getCurrentSession();		
		Producto p = (Producto) session.load(Producto.class, new Integer(id));
		p.setCantidad(p.getCantidad() - quantity);
		p.setVentasTotales(p.getVentasTotales() + quantity);
		DetallesOrden orden = new DetallesOrden();
		orden.setCantidad(quantity);
		orden.setCosto(p.getPrecio() * quantity);
		orden.setIdCliente(0);
		orden.setIdProducto(id);
		orden.setFechaOrden(new Date());
		session.persist(orden);
		session.update(p);
		logger.info("Product was bought, Product Details=" + p);
	}

	public String getAllOrders() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<DetallesOrden> eList = session.createQuery("from DetallesOrden").list();
		Gson gson = new Gson();
		return gson.toJson(eList);
	}
}
