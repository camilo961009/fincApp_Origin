package com.uniquindio.FincApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniquindio.FincApp.dao.IEstateDao;
import com.uniquindio.FincApp.dao.IInsumoDao;
import com.uniquindio.FincApp.dto.InsumoDTO;
import com.uniquindio.FincApp.model.Estate;
import com.uniquindio.FincApp.model.Insumo;

@Service
public class InsumoServiceImpl implements IInsumoService {

	@Autowired
	private IInsumoDao insumoDao;
	@Autowired
	private IEstateDao fincaDao;
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public void deleteById(Long id) {
		insumoDao.deleteById(id);
	}

	@Override
	public List<InsumoDTO> findAll() {
		List<Insumo> insumo = new ArrayList<>();
		insumoDao.findAll().forEach(insumo::add);
		List<InsumoDTO> response = insumo.stream().map(insumoDTO -> {
			return new InsumoDTO(insumoDTO.getIdinsumo(), insumoDTO.getTipo(), insumoDTO.getNombre(),
					insumoDTO.getCantidad(), insumoDTO.getPrecio(), insumoDTO.getFinca().getIdfinca());
		}).collect(Collectors.toList());

		return response;
	}

	@Override
	public InsumoDTO findById(Long id) {

		return entityToDTO(insumoDao.findById(id).orElse(null));
	}

	@Override
	public InsumoDTO saveInsumo(InsumoDTO insumoDTO) {
		Estate finca = fincaDao.findById(1L).get();
		finca.setIdfinca(1L);
		if (finca != null) {
			try {
				Insumo insumo = new Insumo();
				insumo.setIdinsumo(insumoDTO.getIdinsumo());
				insumo.setFinca(finca);
				insumo.setNombre(insumoDTO.getNombre());
				insumo.setTipo(insumoDTO.getTipo());
				insumo.setPrecio(insumoDTO.getPrecio());
				insumo.setCantidad(insumoDTO.getCantidad());
				
				insumoDao.save(insumo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insumoDTO;
	}

	private InsumoDTO entityToDTO(Insumo insumo) {
		InsumoDTO insumoDTO = new InsumoDTO();
		insumoDTO.setFinca(insumo.getFinca().getIdfinca());
		insumoDTO.setIdinsumo(insumo.getIdinsumo());
		insumoDTO.setNombre(insumo.getNombre());
		insumoDTO.setTipo(insumo.getTipo());
		insumoDTO.setCantidad(insumo.getCantidad());
		insumoDTO.setPrecio(insumo.getPrecio());

		return insumoDTO;
	}

}
