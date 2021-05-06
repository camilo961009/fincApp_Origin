/**
 * 
 */
package com.uniquindio.FincApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;



/**
 *Clase que representa a un usuario dentro de la finca
 *
 *
 * @author Darwin Bonilla
 * 
 */

@Entity
@Table(name = "usuario")
public class User implements Serializable{

	@Id
	private Long cedula;
	
	@NotNull
	@Column(nullable = false, unique = true)
	private String correo;
	
	@NotNull
	@Column(nullable = false)
	private String clave;
	
	@NotNull
	@Column(nullable = false)
	private String nombre;

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
