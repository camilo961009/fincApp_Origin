/**
 * 
 */
package com.uniquindio.FincApp.model;

import java.io.Serializable;
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
 * Clase que representa la cosecha de una finca
 * 
 * @author Darwin Bonilla
 *
 */
@Entity
@Table(name = "cosecha")
public class Harvest implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcosecha;

	@Column(nullable = true)
	private int cantidad;

	@Column(nullable = true)
	private Date fecha;

	@Column(nullable = true)
	private Long valor;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "cultivo_idcultivo")
	private Cultivation cultivo;

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

	public Cultivation getCultivo() {
		return cultivo;
	}

	public void setCultivo(Cultivation cultivo) {
		this.cultivo = cultivo;
	}

}
