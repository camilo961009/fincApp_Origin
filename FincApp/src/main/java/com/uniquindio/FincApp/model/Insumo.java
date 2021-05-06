package com.uniquindio.FincApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "insumo")
public class Insumo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idinsumo;

	@NotNull
	@Column(nullable = false)
	private String tipo;

	@NotNull
	@Column(nullable = false)
	private String nombre;

	@Column(nullable = true)
	private int cantidad;

	@Column(nullable = true)
	private Long precio;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "finca_idfinca")
	private Estate finca;

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

	public Estate getFinca() {
		return finca;
	}

	public void setFinca(Estate finca) {
		this.finca = finca;
	}

}
