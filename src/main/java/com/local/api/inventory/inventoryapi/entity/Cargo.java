package com.local.api.inventory.inventoryapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcargo;
	private String descripcion;
	
	public Integer getIdcargo() {
		return idcargo;
	}
	public void setIdcargo(Integer idcargo) {
		this.idcargo = idcargo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Cargo [idcargo=" + idcargo + ", descripcion=" + descripcion + "]";
	}
}
