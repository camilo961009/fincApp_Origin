package com.uniquindio.FincApp.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniquindio.FincApp.dao.ICultivationDao;
import com.uniquindio.FincApp.dto.CultivationDTO;
import com.uniquindio.FincApp.dto.HarvestDTO;
import com.uniquindio.FincApp.model.Cultivation;

@Service
public class CultivationServiceImpl implements ICultivationService {

	@Autowired
	private ICultivationDao cultivoDao;
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public void deleteById(Long id) {
		cultivoDao.deleteById(id);
	}

	@Override
	public List<CultivationDTO> findAll() {
		List<Cultivation> cultivo = new ArrayList<>();
		cultivoDao.findAll().forEach(cultivo::add);
		List<CultivationDTO> response = cultivo.stream().map(cultivoDTO -> {
			return new CultivationDTO(cultivoDTO.getIdcultivo(), cultivoDTO.getTipoCultivo(),
					cultivoDTO.getCantidadDeMatas(), cultivoDTO.getFecha());
		}).collect(Collectors.toList());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		String fecha = "";
		for (CultivationDTO harvest : response) {
			fecha = sdf.format(harvest.getFecha());
			harvest.setFechaFinal(fecha);
		}

		return response;
	}

	@Override
	public CultivationDTO findById(Long id) {
		return entityToDTO(cultivoDao.findById(id).orElse(null));
	}

	@Override
	public CultivationDTO saveCultivation(CultivationDTO cultivationDTO) {

		try {
			Cultivation cultivo = new Cultivation();
			cultivo.setIdcultivo(cultivationDTO.getIdcultivo());
			cultivo.setTipoCultivo(cultivationDTO.getTipoCultivo());
			cultivo.setCantidadDeMatas(cultivationDTO.getCantidadDeMatas());
			cultivo.setFecha(cultivationDTO.getFecha());
			cultivoDao.save(cultivo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cultivationDTO;
	}

	public CultivationDTO entityToDTO(Cultivation cultivation) {
		CultivationDTO cultivationDTO = new CultivationDTO();
		cultivationDTO.setIdcultivo(cultivation.getIdcultivo());
		cultivationDTO.setTipoCultivo(cultivation.getTipoCultivo());
		cultivationDTO.setCantidadDeMatas(cultivation.getCantidadDeMatas());
		cultivationDTO.setFecha(cultivation.getFecha());

		return cultivationDTO;
	}

}
