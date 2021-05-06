/**
 * 
 */
package com.uniquindio.FincApp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/**
 * 
 * Clase que representa a la finca
 * 
 * @author Darwin Bonilla
 *
 */
@Entity
@Table(name = "finca")
public class Estate implements Serializable {

	@Id
	private Long idfinca;

	@NotNull
	@Column(nullable = false)
	private String nombre;

	@NotNull
	private String ubicacion;

	@NotNull
	@Column(nullable = false)
	private String hectareas;

	@NotNull
	@Column(nullable = false)
	private int arriendo;

	@NotNull
	@Column(nullable = false)
	private int servicios;

	@NotNull
	@Column(nullable = false)
	private String usuario_cedula;

	@OneToMany(mappedBy = "finca", cascade = CascadeType.ALL)
	private List<Employee> trabajadores;

	@OneToMany(mappedBy = "finca", cascade = CascadeType.ALL)
	private List<Insumo> insumos;

	public Long getIdfinca() {
		return idfinca;
	}

	public void setIdfinca(Long idfinca) {
		this.idfinca = idfinca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getHectareas() {
		return hectareas;
	}

	public void setHectareas(String hectareas) {
		this.hectareas = hectareas;
	}

	public int getArriendo() {
		return arriendo;
	}

	public void setArriendo(int arriendo) {
		this.arriendo = arriendo;
	}

	public int getServicios() {
		return servicios;
	}

	public void setServicios(int servicios) {
		this.servicios = servicios;
	}

	public String getUsuario_cedula() {
		return usuario_cedula;
	}

	public void setUsuario_cedula(String usuario_cedula) {
		this.usuario_cedula = usuario_cedula;
	}

	public List<Employee> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(List<Employee> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public List<Insumo> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}

}
