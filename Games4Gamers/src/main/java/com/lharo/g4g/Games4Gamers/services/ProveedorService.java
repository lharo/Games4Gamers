package com.lharo.g4g.Games4Gamers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lharo.g4g.Games4Gamers.daos.ProveedorDao;
import com.lharo.g4g.Games4Gamers.models.Proveedor;

@Service
public class ProveedorService {
	
	private ProveedorDao proveedorDao;

	public ProveedorDao getProveedorDao() {
		return proveedorDao;
	}

	public void setProveedorDao(ProveedorDao proveedorDao) {
		this.proveedorDao = proveedorDao;
	}
	
	@Transactional
	public void addProveedor(Proveedor p) {
		//p.setIdProductos(this.productoDao.getMaxId());
		this.proveedorDao.create(p);
	}
	
	@Transactional
	public void updateProveedor(Proveedor p) {
		this.proveedorDao.update(p);
	}
	
	@Transactional
	public List<Proveedor> listProveedor() {
		List<Proveedor> pList = new ArrayList<Proveedor>();
		for(Proveedor e : this.proveedorDao.listAll()) {
			pList.add(e);
		}
		return pList;
	}
	
	@Transactional
	public Proveedor getProveedorById(int id) {
		return this.proveedorDao.getById(id);
	}

	@Transactional
	public void deleteProveedor(int id) {
		this.proveedorDao.delete(id);
	}
	
	@Transactional
	public List<Proveedor> getProveedores(){
		return this.proveedorDao.listAll();
	}
}
