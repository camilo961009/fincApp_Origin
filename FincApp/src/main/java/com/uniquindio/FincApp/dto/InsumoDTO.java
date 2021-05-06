package com.uniquindio.FincApp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class InsumoDTO {

	private Long idinsumo;

	private String tipo;

	private String nombre;

	private int cantidad;

	private Long precio;

	private Long finca;

	public InsumoDTO(Long idinsumo, String tipo, String nombre, int cantidad, Long precio, Long finca) {
		super();
		this.idinsumo = idinsumo;
		this.tipo = tipo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.finca = finca;
	}

	public InsumoDTO() {
		super();
	}

	public Long getIdinsumo() {
		return idinsumo;
	}

	public void setIdinsumo(Long idinsumo) {
		this.idinsumo = idinsumo;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public Long getFinca() {
		return finca;
	}

	public void setFinca(Long finca) {
		this.finca = finca;
	}

}
