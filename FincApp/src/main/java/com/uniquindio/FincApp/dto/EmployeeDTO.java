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
import com.uniquindio.FincApp.model.Estate;

@JsonInclude(Include.NON_NULL)
public class EmployeeDTO {

	private Long cedula;

	private String nombre;

	private String apellido;

	private String horario;

	private Long sueldo;

	private int edad;

	private Long finca;

	private Long cultivo;

	private Date createAt;

	private String email;

	private String cargo;

	private String nombreCultivo;

	private String telefono;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(Long cedula, Date createAt, Cultivation cultivo, int edad, Estate finca, String horario,
			String nombre, Long sueldo, String apellido, String email, String cargo, String telefono) {

		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.horario = horario;
		this.sueldo = sueldo;
		this.edad = edad;
		this.finca = finca.getIdfinca();
		this.cultivo = cultivo.getIdcultivo();
		this.createAt = createAt;
		this.apellido = apellido;
		this.email = email;
		this.cargo = cargo;
		this.telefono = telefono;

	}

	public String getNombreCultivo() {
		return nombreCultivo;
	}

	public void setNombreCultivo(String nombreCultivo) {
		this.nombreCultivo = nombreCultivo;
	}

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

	public Long getFinca() {
		return finca;
	}

	public void setFinca(Long finca) {
		this.finca = finca;
	}

	public Long getCultivo() {
		return cultivo;
	}

	public void setCultivo(Long cultivo) {
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
