package com.uniquindio.FincApp.service;

import java.util.List;

import com.uniquindio.FincApp.dto.PositionDTO;

public interface IPositionService {

	public void deleteById(Long idCargo);

	public List<PositionDTO> findAll();

	public PositionDTO findById(Long idCargo);

	public PositionDTO savePosition(PositionDTO cargo);
}
