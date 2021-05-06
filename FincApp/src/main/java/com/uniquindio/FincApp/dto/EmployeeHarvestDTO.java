package com.uniquindio.FincApp.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sun.istack.NotNull;
import com.uniquindio.FincApp.model.Cultivation;

@JsonInclude(Include.NON_NULL)
public class EmployeeHarvestDTO {

	private Long cedula;

	private String nombre;

	private String apellido;

	private Long pagoPorDia;

	private int diasDeTrabajo;

	private Date fecha;

	private Long cultivo;

	private String telefono;

	public EmployeeHarvestDTO(Long cedula, String nombre, String apellido, Long pagoPorDia, int diasDeTrabajo,
			Date fecha, Cultivation cultivo, String telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pagoPorDia = pagoPorDia;
		this.diasDeTrabajo = diasDeTrabajo;
		this.fecha = fecha;
		this.cultivo = cultivo.getIdcultivo();
		this.telefono = telefono;
	}

	public EmployeeHarvestDTO() {
		super();
	}

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

	public Long getCultivo() {
		return cultivo;
	}

	public void setCultivo(Long cultivo) {
		this.cultivo = cultivo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
