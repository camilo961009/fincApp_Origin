/**
 * 
 */
package com.uniquindio.FincApp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/**
 * Clase que representa los controles que se deben tomar dentro de la finca
 * 
 * @author Darwin Bonilla
 * 
 */
@Entity
@Table(name = "control")
public class Control {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcontrol;
	
	@NotNull
	@Column(nullable = false)
	private String tipo;
	
	@NotNull
	@Column(nullable = false)
	private String nombre;

	@Column(nullable = true)
	private String descripcion;
	
	@Column(nullable = true)
	private Date fecha;
	
	@Column(nullable = true)
	private Long precio;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "cultivo_idcultivo")
	private Cultivation cultivo;

	public Long getIdcontrol() {
		return idcontrol;
	}

	public void setIdcontrol(Long idcontrol) {
		this.idcontrol = idcontrol;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public Cultivation getCultivo() {
		return cultivo;
	}

	public void setCultivo(Cultivation cultivo) {
		this.cultivo = cultivo;
	}
	
	
}
