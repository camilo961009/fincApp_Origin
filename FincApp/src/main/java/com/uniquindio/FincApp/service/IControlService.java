package com.uniquindio.FincApp.service;

import java.util.List;

import com.uniquindio.FincApp.dto.ControlDTO;

public interface IControlService {

	public void deleteById(Long id);

	public List<ControlDTO> findAll();

	public ControlDTO findById(Long id);

	public ControlDTO saveControl(ControlDTO controlDTO);

}
