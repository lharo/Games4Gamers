package com.lharo.g4g.Games4Gamers.daos;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.lharo.g4g.Games4Gamers.entities.GenericDaoImpl;
import com.lharo.g4g.Games4Gamers.models.Empleados;
import com.lharo.g4g.Games4Gamers.util.User;

@Repository
public class UserDao  extends GenericDaoImpl{
	public Boolean validateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from Empleados where usuario =:u ");
		query.setString("u", u.getUsername());
		List<Empleados> list = query.list();
		if(list.get(0).getUsuario().equals(u.getUsername())) {
			if(list.get(0).getContrasenia().equals(com.lharo.g4g.Games4Gamers.util.Utility.digestStr(u.getPassword()))) {
				return true;
			}
		}
		
		return false;
	}
}
