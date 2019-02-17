package com.lharo.g4g.Games4Gamers.daos;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.lharo.g4g.Games4Gamers.entities.GenericDaoImpl;
import com.lharo.g4g.Games4Gamers.models.Proveedor;

@Repository
public class ProveedorDao extends GenericDaoImpl{
	
	public Proveedor getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Proveedor p = (Proveedor) session.load(Proveedor.class, new Integer(id));
		logger.info("Proveedor loaded successfully, details=" + p);
		return p;

	}

	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Proveedor p = (Proveedor) session.load(Proveedor.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Proveedor deleted successfully, Proveedor details=" + p);
	}
	
	@SuppressWarnings("unchecked")
	public List<Proveedor> listAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Proveedor> eList = session.createQuery("from Proveedor").list();
		for(Proveedor e : eList){
			logger.info("Proveedor List::"+ e);
		}
		return eList;

	}

	public void create(Proveedor p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Proveedor saved successfully, Proveedor Details=" + p);		
	}

	public void update(Proveedor p) {

		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Proveedor updated successfully, Proveedor Details=" + p);
		
	}

}
