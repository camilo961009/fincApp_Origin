package com.uniquindio.FincApp.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniquindio.FincApp.dao.IControlDao;
import com.uniquindio.FincApp.dao.ICultivationDao;
import com.uniquindio.FincApp.dto.ControlDTO;
import com.uniquindio.FincApp.dto.CultivationDTO;
import com.uniquindio.FincApp.model.Control;
import com.uniquindio.FincApp.model.Cultivation;

@Service
public class ControlServiceImpl implements IControlService {

	@Autowired
	private IControlDao controlDao;
	@Autowired
	private ICultivationDao cultivoDao;
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public void deleteById(Long id) {
		controlDao.deleteById(id);
	}

	@Override
	public List<ControlDTO> findAll() {
		List<Control> control = new ArrayList<>();
		controlDao.findAll().forEach(control::add);
		List<ControlDTO> response = control.stream().map(controlnDTO -> {
			return new ControlDTO(controlnDTO.getIdcontrol(), controlnDTO.getTipo(), controlnDTO.getNombre(),
					controlnDTO.getDescripcion(), controlnDTO.getFecha(), controlnDTO.getPrecio(),
					controlnDTO.getCultivo().getIdcultivo());
		}).collect(Collectors.toList());
		for (int i = 0; i < response.size(); i++) {
			response.get(i).setNombreCultivo(cultivoDao.findById(response.get(i).getCultivo()).get().getTipoCultivo());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		String fecha = "";
		for (ControlDTO harvest : response) {
			fecha = sdf.format(harvest.getFecha());
			harvest.setFechaFinal(fecha);
		}
		return response;
	}

	@Override
	public ControlDTO findById(Long id) {
		
		return entityToDTO(controlDao.findById(id).orElse(null));
	}

	@Override
	public ControlDTO saveControl(ControlDTO controlDTO) {
		Cultivation cultivo = cultivoDao.findById(controlDTO.getCultivo()).get();
		if (cultivo != null) {
			try {
				Control control = new Control();
				control.setIdcontrol(controlDTO.getIdcontrol());
				control.setCultivo(cultivo);
				control.setNombre(controlDTO.getNombre());
				control.setTipo(controlDTO.getTipo());
				control.setDescripcion(controlDTO.getDescripcion());
				control.setFecha(controlDTO.getFecha());
				control.setPrecio(controlDTO.getPrecio());
				controlDao.save(control);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return controlDTO;
	}
	
	public ControlDTO entityToDTO(Control control) {
		ControlDTO controlDTO = new ControlDTO();
		controlDTO.setCultivo(control.getCultivo().getIdcultivo());
		controlDTO.setIdcontrol(control.getIdcontrol());
		controlDTO.setNombre(control.getNombre());
		controlDTO.setTipo(control.getTipo());
		controlDTO.setFecha(control.getFecha());
		controlDTO.setDescripcion(control.getDescripcion());
		controlDTO.setPrecio(control.getPrecio());

		return controlDTO;
	}

}
