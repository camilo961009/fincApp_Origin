package com.uniquindio.FincApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniquindio.FincApp.dao.ICultivationDao;
import com.uniquindio.FincApp.dao.IEmployeeHarvestDao;
import com.uniquindio.FincApp.dto.EmployeeHarvestDTO;
import com.uniquindio.FincApp.model.Cultivation;
import com.uniquindio.FincApp.model.EmployeeHarvest;

@Service
public class EmployeeHarvestServiceImpl implements IEmployeeHarvestService {

	@Autowired
	private IEmployeeHarvestDao employeeHarvestDao;
	@Autowired
	private ICultivationDao cultivoDao;
	@Autowired
	ObjectMapper objectMapper;
	
	@Override
	public void deleteById(Long cedula) {
		employeeHarvestDao.deleteById(cedula);
	}

	@Override
	public List<EmployeeHarvestDTO> findAll() {
		List<EmployeeHarvest> employee = new ArrayList<>();
		employeeHarvestDao.findAll().forEach(employee::add);
		List<EmployeeHarvestDTO> response = employee.stream().map(employeeDTO -> {
			return new EmployeeHarvestDTO(employeeDTO.getCedula(), employeeDTO.getNombre(), employeeDTO.getApellido(),
					employeeDTO.getPagoPorDia(),employeeDTO.getDiasDeTrabajo(), employeeDTO.getFecha(), employeeDTO.getCultivo(), employeeDTO.getTelefono());
		}).collect(Collectors.toList());

		return response;
	}

	@Override
	public EmployeeHarvestDTO findById(Long cedula) {
		
		return entityToDTO(employeeHarvestDao.findById(cedula).orElse(null));
	}

	@Override
	public EmployeeHarvestDTO saveEmployeeHarvest(EmployeeHarvestDTO employeeDTO) {
		Cultivation cultivo = cultivoDao.findById(9L).get();
		cultivo.setIdcultivo(9L);
		if (cultivo != null) {
			try {
				EmployeeHarvest employee = new EmployeeHarvest();
				
				employee.setCultivo(cultivo);
				employee.setCedula(employeeDTO.getCedula());
				employee.setFecha(employeeDTO.getFecha());				
				employee.setNombre(employeeDTO.getNombre());
				employee.setPagoPorDia(employeeDTO.getPagoPorDia());
				employee.setApellido(employeeDTO.getApellido());
				employee.setDiasDeTrabajo(employeeDTO.getDiasDeTrabajo());
				employee.setTelefono(employeeDTO.getTelefono());
				employeeHarvestDao.save(employee);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return employeeDTO;
	}
	
	public EmployeeHarvestDTO entityToDTO(EmployeeHarvest employee) {
		EmployeeHarvestDTO employeeDTO = new EmployeeHarvestDTO();
		employeeDTO.setCultivo(employee.getCultivo().getIdcultivo());
		employeeDTO.setCedula(employee.getCedula());
		employeeDTO.setFecha(employee.getFecha());	
		employeeDTO.setNombre(employee.getNombre());
		employeeDTO.setPagoPorDia(employee.getPagoPorDia());
		employeeDTO.setApellido(employee.getApellido());
		employeeDTO.setDiasDeTrabajo(employee.getDiasDeTrabajo());

		return employeeDTO;
	}

}
