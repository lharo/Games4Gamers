package com.lharo.g4g.Games4Gamers.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_proveedores")
	private int idProveedores;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "email")
	private String email;
	@Column(name = "terminos")
	private String terminos;
	
	public int getIdProveedores() {
		return idProveedores;
	}
	public void setIdProveedores(int idProveedores) {
		this.idProveedores = idProveedores;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTerminos() {
		return terminos;
	}
	public void setTerminos(String terminos) {
		this.terminos = terminos;
	}
}
