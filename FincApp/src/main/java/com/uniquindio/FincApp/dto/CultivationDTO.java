package com.uniquindio.FincApp.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CultivationDTO {

	private Long idcultivo;

	private String tipoCultivo;

	private int cantidadDeMatas;

	private Date fecha;
	
	private String fechaFinal;

	public CultivationDTO(Long idcultivo, String tipoCultivo, int cantidadDeMatas, Date fecha) {
		super();
		this.idcultivo = idcultivo;
		this.tipoCultivo = tipoCultivo;
		this.cantidadDeMatas = cantidadDeMatas;
		this.fecha = fecha;
	}

	public CultivationDTO() {
		super();
	}

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

	public void setCantidadDeMatas(int cantidadDeMatas) {
		this.cantidadDeMatas = cantidadDeMatas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

}
