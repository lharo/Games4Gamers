package com.lharo.g4g.Games4Gamers.entities;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoImpl implements GenericDao{

	protected static final Logger logger = LoggerFactory.getLogger(GenericDaoImpl.class);

	protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
}
