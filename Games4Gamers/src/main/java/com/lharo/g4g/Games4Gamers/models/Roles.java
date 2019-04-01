package com.lharo.g4g.Games4Gamers.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cat_roles")
public class Roles implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_cat_roles")
	private int idRol;
	@Column(name = "nombre_rol")
	private String nombreRol;

}
