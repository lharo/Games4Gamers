package com.lharo.g4g.Games4Gamers.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lharo.g4g.Games4Gamers.daos.MailDao;

@Service
public class MailService {
	private MailDao mailDao;
	
	public MailDao getMailDao() {
		return mailDao;
	}

	public void setMailDao(MailDao mailDao) {
		this.mailDao = mailDao;
	}

	@Transactional
	public void addCatalogoTipoProducto(String p) {
		//p.setIdProductos(this.productoDao.getMaxId());
		//this.catalogoTipoProducto.create(p);
	}

}
