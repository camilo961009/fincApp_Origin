package com.uniquindio.FincApp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.uniquindio.FincApp.model.Employee;

@JsonInclude(Include.NON_NULL)
public class PositionDTO {

	private Long idcargo;

	private String tipoCargo;

	private Long trabajadorCedula;

	public PositionDTO(Long idcargo, String tipoCargo, Long trabajadorCedula) {
		super();
		this.idcargo = idcargo;
		this.tipoCargo = tipoCargo;
		this.trabajadorCedula = trabajadorCedula;
	}

	public PositionDTO() {
		super();
	}

	public Long getIdCargo() {
		return idcargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idcargo = idCargo;
	}

	public String getTipoCargo() {
		return tipoCargo;
	}

	public void setTipoCargo(String tipoCargo) {
		this.tipoCargo = tipoCargo;
	}

	public Long getTrabajadorCedula() {
		return trabajadorCedula;
	}

	public void setTrabajadorCedula(Long trabajadorCedula) {
		this.trabajadorCedula = trabajadorCedula;
	}

}
