package com.uniquindio.FincApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/**
 * Clase que representa el cargo de un trabajador dentro de la finca
 * 
 * @author Darwin Bonilla
 * 
 */
@Entity
@Table(name = "cargo")
public class Position {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcargo;
	@NotNull
	@Column(nullable = false)
	private String tipoCargo;
	@ManyToOne
	@NotNull
	@JoinColumn(name = "trabajador_cedula")
	private Employee trabajadorCedula;
	public Long getIdCargo() {
		return idcargo;
	}
	public void setIdCargo(Long idCargo) {
		this.idcargo = idCargo;
	}
	public String getTipoCargo() {
		return tipoCargo;
	}
	public void setTipoCargo(String tipoCargo) {
		this.tipoCargo = tipoCargo;
	}
	public Employee getTrabajadorCedula() {
		return trabajadorCedula;
	}
	public void setTrabajadorCedula(Employee trabajadorCedula) {
		this.trabajadorCedula = trabajadorCedula;
	}
	
    
}
