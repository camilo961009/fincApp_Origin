package com.uniquindio.FincApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniquindio.FincApp.dto.CultivationDTO;
import com.uniquindio.FincApp.service.ICultivationService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/cultivation")
public class CultivationController {
	
	@Autowired
	private ICultivationService cultivoService;
	
	@PostMapping("/cultivos")
	public CultivationDTO saveCultivation(@RequestBody CultivationDTO cultivation) {
		return cultivoService.saveCultivation(cultivation);
	}

	@DeleteMapping("/cultivos/{id}")
	public void deleteCultivationById(@PathVariable Long id) {
		cultivoService.deleteById(id);
	}

	@GetMapping("/cultivos/{id}")
	public CultivationDTO findCultivationById(@PathVariable Long id) {
		return cultivoService.findById(id);
	}

	@GetMapping("/cultivos")
	public List<CultivationDTO> findAllCultivation() {
		return cultivoService.findAll();
	}

	@PutMapping("/cultivos/{id}")
	public CultivationDTO updateCultivation(@RequestBody CultivationDTO cultivation, @PathVariable Long id) {
		CultivationDTO cultivationDTO = cultivoService.findById(id);
		CultivationDTO cultivationUpdated = null;
		if (cultivationDTO != null) {

			try {
				cultivationDTO.setTipoCultivo(cultivation.getTipoCultivo());
				cultivationDTO.setCantidadDeMatas(cultivation.getCantidadDeMatas());
				cultivationDTO.setFecha(cultivation.getFecha());

				cultivationUpdated = cultivoService.saveCultivation(cultivationDTO);
				return cultivationUpdated;
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		}
		return cultivationUpdated;
	}

}
