package com.uniquindio.FincApp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniquindio.FincApp.dto.EmployeeHarvestDTO;
import com.uniquindio.FincApp.service.IEmployeeHarvestService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/employeeHarvest")
public class EmployeeHarvestController {

	@Autowired
	private IEmployeeHarvestService employeeService;
	
	@PostMapping("/trabajadoresCosechas")
	public EmployeeHarvestDTO saveEmployee(@RequestBody EmployeeHarvestDTO employee) {
		employee.setFecha(new Date());
		return employeeService.saveEmployeeHarvest(employee);
	}

	@DeleteMapping("/trabajadoresCosechas/{cedula}")
	public void deleteEmployeeById(@PathVariable Long cedula) {
		employeeService.deleteById(cedula);
	}

	@GetMapping("/trabajadoresCosechas/{cedula}")
	public EmployeeHarvestDTO findEmployee(@PathVariable Long cedula) {
		return employeeService.findById(cedula);
	}

	@GetMapping("/trabajadoresCosechas")
	public List<EmployeeHarvestDTO> findAllEmployee() {
		return employeeService.findAll();
	}

	@PutMapping("/trabajadoresCosechas/{cedula}")
	public EmployeeHarvestDTO updateEmployee(@RequestBody EmployeeHarvestDTO peticion, @PathVariable Long cedula) {

		EmployeeHarvestDTO employeeDTO = employeeService.findById(cedula);

		EmployeeHarvestDTO employeeUpdated = null;
		if (employeeDTO != null) {

			try {
				employeeDTO.setNombre(peticion.getNombre());
				employeeDTO.setApellido(peticion.getApellido());
				employeeDTO.setPagoPorDia(peticion.getPagoPorDia());
				employeeDTO.setDiasDeTrabajo(peticion.getDiasDeTrabajo());
				employeeDTO.setCultivo(peticion.getCultivo());
				employeeDTO.setTelefono(peticion.getTelefono());

				employeeUpdated = employeeService.saveEmployeeHarvest(employeeDTO);
				return employeeUpdated;
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		}
		return employeeUpdated;
	}
	
}
