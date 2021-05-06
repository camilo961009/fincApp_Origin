package com.uniquindio.FincApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniquindio.FincApp.dao.IEmployeeDao;
import com.uniquindio.FincApp.dao.IPositionDao;
import com.uniquindio.FincApp.dto.PositionDTO;
import com.uniquindio.FincApp.model.Employee;
import com.uniquindio.FincApp.model.Position;

@Service
public class PositionServicioImpl implements IPositionService {

	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	private IPositionDao positionDao;
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public void deleteById(Long idCargo) {
		positionDao.deleteById(idCargo);
	}

	@Override
	public List<PositionDTO> findAll() {
		List<Position> position = new ArrayList<>();
		positionDao.findAll().forEach(position::add);
		List<PositionDTO> response = position.stream().map(positionDTO -> {
			return new PositionDTO(positionDTO.getIdCargo(), positionDTO.getTipoCargo(),
					positionDTO.getTrabajadorCedula().getCedula());
		}).collect(Collectors.toList());

		return response;
	}

	@Override
	public PositionDTO findById(Long idCargo) {
		return entityToDTO(positionDao.findById(idCargo).orElse(null));
	}

	@Override
	public PositionDTO savePosition(PositionDTO cargoDTO) {
		Employee employee = employeeDao.findById(cargoDTO.getTrabajadorCedula()).get();
		if (employee != null) {
			try {
				Position cargo = new Position();
				cargo.setIdCargo(cargoDTO.getIdCargo());
				cargo.setTipoCargo(cargoDTO.getTipoCargo());
				cargo.setTrabajadorCedula(employee);
				positionDao.save(cargo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cargoDTO;
	}

	public PositionDTO entityToDTO(Position cargo) {
		PositionDTO cargoDTO = new PositionDTO();
		cargoDTO.setTrabajadorCedula(cargo.getTrabajadorCedula().getCedula());
		cargoDTO.setTipoCargo(cargo.getTipoCargo());
		cargoDTO.setIdCargo(cargo.getIdCargo());

		return cargoDTO;
	}

}
