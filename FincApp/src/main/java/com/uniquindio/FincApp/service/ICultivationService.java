package com.uniquindio.FincApp.service;

import java.util.List;

import com.uniquindio.FincApp.dto.CultivationDTO;

public interface ICultivationService {

	public void deleteById(Long id);
	
	public List<CultivationDTO> findAll();
	
	public CultivationDTO findById(Long id);

	public CultivationDTO saveCultivation(CultivationDTO cultivation);
}
