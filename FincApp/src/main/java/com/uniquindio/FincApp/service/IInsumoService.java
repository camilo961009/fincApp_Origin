package com.uniquindio.FincApp.service;

import java.util.List;

import com.uniquindio.FincApp.dto.InsumoDTO;

public interface IInsumoService {
	
	public void deleteById(Long id);

	public List<InsumoDTO> findAll();

	public InsumoDTO findById(Long id);

	public InsumoDTO saveInsumo(InsumoDTO insumoDTO);

}
