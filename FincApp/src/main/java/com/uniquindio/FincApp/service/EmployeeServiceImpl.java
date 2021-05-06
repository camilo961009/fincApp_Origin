package com.uniquindio.FincApp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniquindio.FincApp.dao.ICultivationDao;
import com.uniquindio.FincApp.dao.IEmployeeDao;
import com.uniquindio.FincApp.dao.IEstateDao;
import com.uniquindio.FincApp.dto.CultivationDTO;
import com.uniquindio.FincApp.dto.EmployeeDTO;
import com.uniquindio.FincApp.model.Cultivation;
import com.uniquindio.FincApp.model.Employee;
import com.uniquindio.FincApp.model.Estate;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;
	@Autowired
	private IEstateDao fincaDao;
	@Autowired
	private ICultivationDao cultivoDao;
	@Autowired
	ObjectMapper objectMapper;
//	@Autowired
//	private CultivationDTO cultivoDTO;

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
		Estate finca = fincaDao.findById(1L).get();
		finca.setIdfinca(1L);
		Cultivation cultivo = cultivoDao.findById(employeeDTO.getCultivo()).get();
		if (finca != null && cultivo != null) {
			try {
				Employee employee = new Employee();
				employee.setFinca(finca);
				employee.setCultivo(cultivo);
				employee.setCedula(employeeDTO.getCedula());
				employee.setCreateAt(employeeDTO.getCreateAt());
				employee.setEdad(employeeDTO.getEdad());
				employee.setHorario(employeeDTO.getHorario());
				employee.setNombre(employeeDTO.getNombre());
				employee.setSueldo(employeeDTO.getSueldo());
				employee.setApellido(employeeDTO.getApellido());
				employee.setEmail(employeeDTO.getEmail());
				employee.setCargo(employeeDTO.getCargo());
				employee.setTelefono(employeeDTO.getTelefono());
				employeeDao.save(employee);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return employeeDTO;
	}

	@Override
	public void deleteById(Long cedula) {
		employeeDao.deleteById(cedula);
	}

	@Override
	public List<EmployeeDTO> findAll() {
		List<Employee> employee = new ArrayList<>();
		employeeDao.findAll().forEach(employee::add);
		List<EmployeeDTO> response = employee.stream().map(employeeDTO -> {
			return new EmployeeDTO(employeeDTO.getCedula(), employeeDTO.getCreateAt(), employeeDTO.getCultivo(),
					employeeDTO.getEdad(), employeeDTO.getFinca(), employeeDTO.getHorario(), employeeDTO.getNombre(),
					employeeDTO.getSueldo(), employeeDTO.getApellido(), employeeDTO.getEmail(), employeeDTO.getCargo(), employeeDTO.getTelefono());
		}).collect(Collectors.toList());
		for (int i = 0; i < response.size(); i++) {
			response.get(i).setNombreCultivo(cultivoDao.findById(response.get(i).getCultivo()).get().getTipoCultivo());
		}

		return response;
	}

	@Override
	public EmployeeDTO findById(Long cedula) {

		return entityToDTO(employeeDao.findById(cedula).orElse(null));
	}

	public EmployeeDTO entityToDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setFinca(employee.getFinca().getIdfinca());
		employeeDTO.setCultivo(employee.getCultivo().getIdcultivo());
		employeeDTO.setCedula(employee.getCedula());
		employeeDTO.setCreateAt(employee.getCreateAt());
		employeeDTO.setEdad(employee.getEdad());
		employeeDTO.setHorario(employee.getHorario());
		employeeDTO.setNombre(employee.getNombre());
		employeeDTO.setSueldo(employee.getSueldo());
		employeeDTO.setApellido(employee.getApellido());
		employeeDTO.setEmail(employee.getEmail());
		employeeDTO.setCargo(employee.getCargo());
		employeeDTO.setTelefono(employee.getTelefono());

		return employeeDTO;
	}

}
