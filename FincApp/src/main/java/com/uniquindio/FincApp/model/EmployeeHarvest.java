package com.uniquindio.FincApp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
@Table(name = "trabajadorcosecha")
public class EmployeeHarvest implements Serializable {

	@Id
	private Long cedula;

	@NotNull
	@Column(nullable = false)
	private String nombre;

	@NotNull
	@Column(nullable = false)
	private String apellido;

	@Column(nullable = true)
	private Long pagoPorDia;

	@Column(nullable = true)
	private int diasDeTrabajo;

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "cultivo_idcultivo")
	private Cultivation cultivo;

	@Column(nullable = true)
	private String telefono;

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getPagoPorDia() {
		return pagoPorDia;
	}

	public void setPagoPorDia(Long pagoPorDia) {
		this.pagoPorDia = pagoPorDia;
	}

	public int getDiasDeTrabajo() {
		return diasDeTrabajo;
	}

	public void setDiasDeTrabajo(int diasDeTrabajo) {
		this.diasDeTrabajo = diasDeTrabajo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cultivation getCultivo() {
		return cultivo;
	}

	public void setCultivo(Cultivation cultivo) {
		this.cultivo = cultivo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
