package com.local.api.inventory.inventoryapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducto")
	private Integer idProducto;
	
	@Column(name = "nombre_producto")
	private String nombreProducto;
	
	private Integer cantidad;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;
	
	@OneToOne
	@JoinColumn(name = "usuario_registro")
	@Fetch(FetchMode.JOIN)
	private Usuario usuarioRegistro;
	
	@OneToOne
	@JoinColumn(name = "usuario_actualiza")
	private Usuario usuarioActualiza;
	
	@Column(name = "fecha_actualiza")
	private Date fechaActualiza;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Usuario getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(Usuario usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Usuario getUsuarioActualiza() {
		return usuarioActualiza;
	}

	public void setUsuarioActualiza(Usuario usuarioActualiza) {
		this.usuarioActualiza = usuarioActualiza;
	}

	public Date getFechaActualiza() {
		return fechaActualiza;
	}

	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad
				+ ", fechaIngreso=" + fechaIngreso + ", usuarioRegistro=" + usuarioRegistro + ", usuarioActualiza="
				+ usuarioActualiza + ", fechaActualiza=" + fechaActualiza + "]";
	}
	
}
