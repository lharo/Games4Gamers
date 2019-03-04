package com.lharo.g4g.Games4Gamers.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalles_orden")
public class DetallesOrden implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_detalles_orden")
	private int idDetallesOrden;
	@Column(name = "id_producto")
	private int idProducto;
	@Column(name = "cantidad")
	private int cantidad;
	@Column(name = "id_cliente")
	private int idCliente;
	@Column(name = "costo")
	private double costo;
	@Column(name = "fecha_orden")
	private Date fechaOrden;
	
	public int getIdDetallesOrden() {
		return idDetallesOrden;
	}
	public void setIdDetallesOrden(int idDetallesOrden) {
		this.idDetallesOrden = idDetallesOrden;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public Date getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
}
