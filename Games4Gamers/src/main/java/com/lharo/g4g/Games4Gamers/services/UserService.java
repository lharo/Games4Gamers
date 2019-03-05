package com.lharo.g4g.Games4Gamers.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lharo.g4g.Games4Gamers.daos.UserDao;
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
	public Boolean validateUser(User u) {
		return this.userDao.validateUser(u);
	}
}
