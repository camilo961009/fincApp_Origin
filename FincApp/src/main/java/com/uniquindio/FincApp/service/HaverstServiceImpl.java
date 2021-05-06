package com.uniquindio.FincApp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniquindio.FincApp.dao.ICultivationDao;
import com.uniquindio.FincApp.dao.IHaverstDao;
import com.uniquindio.FincApp.dto.EmployeeDTO;
import com.uniquindio.FincApp.dto.HarvestDTO;
import com.uniquindio.FincApp.model.Cultivation;
import com.uniquindio.FincApp.model.Employee;
import com.uniquindio.FincApp.model.Harvest;

@Service
public class HaverstServiceImpl implements IHaverstService {

	@Autowired
	private IHaverstDao haverstDao;
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	private ICultivationDao cultivoDao;

	@Override
	public void deleteById(Long id) {
		haverstDao.deleteById(id);
	}

	@Override
	public List<HarvestDTO> findAll() {
		List<Harvest> cosecha = new ArrayList<>();
		haverstDao.findAll().forEach(cosecha::add);
		List<HarvestDTO> response = cosecha.stream().map(cosechaDTO -> {
			return new HarvestDTO(cosechaDTO.getIdcosecha(), cosechaDTO.getCantidad(), cosechaDTO.getFecha(),
					cosechaDTO.getValor(), cosechaDTO.getCultivo());
		}).collect(Collectors.toList());
		for (int i = 0; i < response.size(); i++) {
			response.get(i).setNombreCultivo(cultivoDao.findById(response.get(i).getCultivo()).get().getTipoCultivo());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		String fecha = "";
		for (HarvestDTO harvest : response) {
			fecha = sdf.format(harvest.getFecha());
			System.out.println(fecha+"-------");
			harvest.setFechaFinal(fecha);
		}

		return response;
	}

	@Override
	public HarvestDTO findById(Long id) {
		return entityToDTO(haverstDao.findById(id).orElse(null));
	}

	@Override
	public HarvestDTO saveHarvest(HarvestDTO haverstDTO) {
		Cultivation cultivo = cultivoDao.findById(haverstDTO.getCultivo()).get();
		if (cultivo != null) {
			try {
				Harvest haverst = new Harvest();
				haverst.setIdcosecha(haverstDTO.getIdcosecha());
				haverst.setCultivo(cultivo);
				haverst.setCantidad(haverstDTO.getCantidad());
				haverst.setValor(haverstDTO.getValor());
				haverst.setFecha(haverstDTO.getFecha());
				haverstDao.save(haverst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return haverstDTO;
	}

	public HarvestDTO entityToDTO(Harvest harvest) {
		HarvestDTO haverstDTO = new HarvestDTO();
		haverstDTO.setIdcosecha(harvest.getIdcosecha());
		haverstDTO.setCantidad(harvest.getCantidad());
		haverstDTO.setFecha(harvest.getFecha());
		haverstDTO.setValor(harvest.getValor());
		haverstDTO.setCultivo(harvest.getCultivo().getIdcultivo());

		return haverstDTO;
	}
}
