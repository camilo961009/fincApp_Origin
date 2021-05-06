package com.uniquindio.FincApp.service;

import java.util.List;

import com.uniquindio.FincApp.dto.EmployeeHarvestDTO;

public interface IEmployeeHarvestService {

	public void deleteById(Long cedula);

	public List<EmployeeHarvestDTO> findAll();

	public EmployeeHarvestDTO findById(Long cedula);

	public EmployeeHarvestDTO saveEmployeeHarvest(EmployeeHarvestDTO employeeHarvest);

}
