package com.lharo.g4g.Games4Gamers.daos;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.lharo.g4g.Games4Gamers.entities.GenericDaoImpl;
import com.lharo.g4g.Games4Gamers.models.Roles;
import com.lharo.g4g.Games4Gamers.models.Usuarios;
import com.lharo.g4g.Games4Gamers.util.User;

@Repository
public class UserDao  extends GenericDaoImpl{

		public Usuarios getById(int id) {
			Session session = this.sessionFactory.getCurrentSession();		
			Usuarios u = (Usuarios) session.load(Usuarios.class, new Integer(id));
			logger.info("User loaded successfully, details=" + u);
			return u;

		}

		public void delete(int id) {
			Session session = this.sessionFactory.getCurrentSession();
			Usuarios u = (Usuarios) session.load(Usuarios.class, new Integer(id));
			if(null != u){
				session.delete(u);
			}
			logger.info("User deleted successfully, Product details=" + u);
		}
		
		@SuppressWarnings("unchecked")
		public List<Usuarios> listAll() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Usuarios> uList = session.createQuery("from Usuarios").list();
			for(Usuarios u : uList){
				logger.info("User List::"+ u);
			}
			return uList;
		}

		public void create(Usuarios u) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(u);
			logger.info("Usuarios saved successfully, Usuarios Details=" + u);		
		}

		public void update(Usuarios u) {

			Session session = this.sessionFactory.getCurrentSession();
			session.update(u);
			logger.info("Usuarios updated successfully, Usuarios Details=" + u);
			
		}
			
	public Boolean validateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from Usuarios where nombreUsuario =:u ");
		query.setString("u", u.getUsername());
		List<Usuarios> list = query.list();
		
		/*
		Gson gson = new Gson();
		System.out.println("UserName " + u.getUsername());
		System.out.println("User " + gson.toJson(list));
		System.out.println("Password " + u.getPassword() + " encrypted: " + com.lharo.g4g.Games4Gamers.util.Utility.digestStr(u.getPassword()));
		*/
		if(list != null && list.size() > 0) {
			if(list.get(0).getContrasenia().equals(com.lharo.g4g.Games4Gamers.util.Utility.digestStr(u.getPassword()))) {
				//session.getSession().setAttribute("cart",value);
				return true;
			}
		}		
		return false;
	}
	
}
