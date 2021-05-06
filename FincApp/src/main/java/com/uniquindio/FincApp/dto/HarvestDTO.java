/**
 * 
 */
package com.uniquindio.FincApp.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.uniquindio.FincApp.model.Cultivation;

/**
 * @author LENOVO
 *
 */

@JsonInclude(Include.NON_NULL)
public class HarvestDTO {

	private Long idcosecha;

	private int cantidad;

	private Date fecha;

	private Long valor;

	private Long cultivo;
	
	private String nombreCultivo;

	private String fechaFinal;
	
	public HarvestDTO(Long idcosecha, int cantidad, Date fecha, Long valor, Cultivation cultivation) {
		super();
		this.idcosecha = idcosecha;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.valor = valor;
		this.cultivo = cultivation.getIdcultivo();
	}
	
	public String getNombreCultivo() {
		return nombreCultivo;
	}

	public void setNombreCultivo(String nombreCultivo) {
		this.nombreCultivo = nombreCultivo;
	}

	public HarvestDTO() {
		super();
	}

	public Long getIdcosecha() {
		return idcosecha;
	}

	public void setIdcosecha(Long idcosecha) {
		this.idcosecha = idcosecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
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
