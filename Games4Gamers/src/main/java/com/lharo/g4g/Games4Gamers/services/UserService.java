package com.lharo.g4g.Games4Gamers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lharo.g4g.Games4Gamers.daos.UserDao;
import com.lharo.g4g.Games4Gamers.models.CatalogoTipoProducto;
import com.lharo.g4g.Games4Gamers.models.Producto;
import com.lharo.g4g.Games4Gamers.models.Proveedor;
import com.lharo.g4g.Games4Gamers.models.Roles;
import com.lharo.g4g.Games4Gamers.models.Usuarios;
import com.lharo.g4g.Games4Gamers.util.User;

@Service
public class UserService {
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public void addUser(Usuarios u) {
		//p.setIdProductos(this.productoDao.getMaxId());
		this.userDao.create(u);
	}
	
	@Transactional
	public void updateUser(Usuarios u) {
		this.userDao.update(u);
	}
	
	@Transactional
	public List<Usuarios> listUsuarios() {
		List<Usuarios> uList = new ArrayList<Usuarios>();
		for(Usuarios u : this.userDao.listAll()) {
			uList.add(u);
		}
		return uList;
	}
	
	@Transactional
	public Usuarios getUserById(int id) {
		return this.userDao.getById(id);
	}

	@Transactional
	public void deleteUser(int id) {
		this.userDao.delete(id);
	}

	@Transactional
	public Boolean validateUser(User u) {
		return this.userDao.validateUser(u);
	}
}
