package com.lharo.g4g.Games4Gamers.daos;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.lharo.g4g.Games4Gamers.entities.GenericDaoImpl;
import com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto;

@Repository
public class CatalogoTipoProductoDao extends GenericDaoImpl{

	public CatalogoTipoProducto getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		CatalogoTipoProducto p = (CatalogoTipoProducto) session.load(CatalogoTipoProducto.class, new Integer(id));
		logger.info("CatalogoTipoProducto loaded successfully, details=" + p);
		return p;

	}

	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		CatalogoTipoProducto p = (CatalogoTipoProducto) session.load(CatalogoTipoProducto.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("CatalogoTipoProducto deleted successfully, CatalogoTipoProducto details=" + p);
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


	public void create(CatalogoTipoProducto p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("CatalogoTipoProducto saved successfully, CatalogoTipoProducto Details=" + p);		
	}

	public void update(CatalogoTipoProducto p) {

		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("CatalogoTipoProducto updated successfully, CatalogoTipoProducto Details=" + p);
		
	}	

}
