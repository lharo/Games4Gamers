package com.lharo.g4g.Games4Gamers.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_productos")
	private int idProductos;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "precio")
	private double precio;
	@Column(name= "id_tipo_producto")
	private Integer idTipoProducto;
	
	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}
	public int getIdProductos() {
		return idProductos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Integer getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setIdTipoProducto(Integer idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	@Override
	public String toString() {
		return "Producto [idProductos=" + idProductos + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + "]";
	}
	
}