package com.uniquindio.FincApp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.uniquindio.FincApp.dto.EmployeeDTO;


public interface IEmployeeService {
	
	public void deleteById(Long cedula);
	
	public List<EmployeeDTO> findAll();
	
	public EmployeeDTO findById(Long cedula);

	public EmployeeDTO saveEmployee(EmployeeDTO employee);	

}
