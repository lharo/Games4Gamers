package com.lharo.g4g.Games4Gamers.daos;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.lharo.g4g.Games4Gamers.entities.GenericDaoImpl;

@Repository
public class MailDao extends GenericDaoImpl{

	public void getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		//Producto p = (Producto) session.load(Producto.class, new Integer(id));
		//logger.info("Producto loaded successfully, details=" + p);
		return;

	}
}
