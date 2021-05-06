package com.uniquindio.FincApp.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ControlDTO {

	private Long idcontrol;

	private String tipo;

	private String nombre;

	private String descripcion;

	private Date fecha;

	private Long precio;

	private Long cultivo;
	
	private String nombreCultivo;
	
	private String fechaFinal;

	public ControlDTO(Long idcontrol, String tipo, String nombre, String descripcion, Date fecha, Long precio,
			Long cultivo) {
		super();
		this.idcontrol = idcontrol;
		this.tipo = tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.precio = precio;
		this.cultivo = cultivo;
	}
	
	public String getNombreCultivo() {
		return nombreCultivo;
	}

	public void setNombreCultivo(String nombreCultivo) {
		this.nombreCultivo = nombreCultivo;
	}

	public ControlDTO() {
		super();
	}

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

	public Long getCultivo() {
		return cultivo;
	}

	public void setCultivo(Long cultivo) {
		this.cultivo = cultivo;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

}
