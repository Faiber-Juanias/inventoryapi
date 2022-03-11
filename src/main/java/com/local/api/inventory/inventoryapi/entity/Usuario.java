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

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario")
	private Integer idUsuario;
	
	private Integer edad;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;
	
	@OneToOne
	@JoinColumn(name = "cargo_idcargo")
	private Cargo cargoIdCargo;
	
	private String nombre;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Cargo getCargoIdCargo() {
		return cargoIdCargo;
	}

	public void setCargoIdCargo(Cargo cargoIdCargo) {
		this.cargoIdCargo = cargoIdCargo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", edad=" + edad + ", fechaIngreso=" + fechaIngreso
				+ ", cargoIdCargo=" + cargoIdCargo + ", nombre=" + nombre + "]";
	}

}
