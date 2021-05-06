/**
 * 
 */
package com.uniquindio.FincApp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/**
 * 
 * Clase que representa un cultivo dentro de la finca
 * 
 * @author Darwin Bonilla
 *
 */
@Entity
@Table(name = "cultivo")
public class Cultivation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcultivo;

	@NotNull
	@Column(nullable = false)
	private String tipoCultivo;

	@Column(nullable = true)
	private int cantidadDeMatas;

	@Column(nullable = true)
	private Date fecha;

	@OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL)
	private List<Employee> trabajadores;

	@OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL)
	private List<Harvest> cosechas;

	@OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL)
	private List<Control> controles;
	
	@OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL)
	private List<EmployeeHarvest> trabajadoresCosechas;
	
	public Long getIdcultivo() {
		return idcultivo;
	}

	public void setIdcultivo(Long idcultivo) {
		this.idcultivo = idcultivo;
	}

	public String getTipoCultivo() {
		return tipoCultivo;
	}

	public void setTipoCultivo(String tipoCultivo) {
		this.tipoCultivo = tipoCultivo;
	}

	public int getCantidadDeMatas() {
		return cantidadDeMatas;
	}

	public void setCantidadDeMatas(int cantidad) {
		this.cantidadDeMatas = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Employee> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(List<Employee> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public List<Harvest> getCosechas() {
		return cosechas;
	}

	public void setCosechas(List<Harvest> cosechas) {
		this.cosechas = cosechas;
	}

	public List<Control> getControles() {
		return controles;
	}

	public void setControles(List<Control> controles) {
		this.controles = controles;
	}

	
}
