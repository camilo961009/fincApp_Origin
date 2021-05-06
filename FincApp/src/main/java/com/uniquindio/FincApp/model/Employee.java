/**
 * 
 */
package com.uniquindio.FincApp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

/**
 * Clase que representa a un trabajador dentro de la finca
 * 
 * @author Darwin Bonilla
 * 
 *
 */
@Entity
@Table(name = "trabajador")
public class Employee implements Serializable {

	@Id
	private Long cedula;

	@NotNull
	@Column(nullable = false)
	private String nombre;

	@Column(nullable = true)
	private String horario;

	@NotNull
	@Column(nullable = false)
	private String apellido;

	@NotNull
	@Column(nullable = false)
	private Long sueldo;

	@Column(nullable = true)
	private int edad;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "finca_idfinca")
	private Estate finca;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "cultivo_idcultivo")
	private Cultivation cultivo;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@NotNull
	@Column(nullable = false)
	private String email;

	@NotNull
	@Column(nullable = false)
	private String cargo;

	@Column(nullable = true)
	private String telefono;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Long getSueldo() {
		return sueldo;
	}

	public void setSueldo(Long sueldo) {
		this.sueldo = sueldo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Estate getFinca() {
		return finca;
	}

	public void setFinca(Estate finca) {
		this.finca = finca;
	}

	public Cultivation getCultivo() {
		return cultivo;
	}

	public void setCultivo(Cultivation cultivo) {
		this.cultivo = cultivo;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
