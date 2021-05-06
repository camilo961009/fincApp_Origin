package com.uniquindio.FincApp.service;

import java.util.List;

import com.uniquindio.FincApp.dto.HarvestDTO;

public interface IHaverstService {
	
	public void deleteById(Long id);
	
	public List<HarvestDTO> findAll();
	
	public HarvestDTO findById(Long id);

	public HarvestDTO saveHarvest(HarvestDTO haverst);

}
