package com.uniquindio.FincApp.controller;

import java.util.Date;
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

import com.uniquindio.FincApp.dto.HarvestDTO;
import com.uniquindio.FincApp.service.IHaverstService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/harvest")
public class HarvestController {
	
	@Autowired
	private IHaverstService harvestService;

	@PostMapping("/cosechas")
	public HarvestDTO saveEmployee(@RequestBody HarvestDTO harvest) {

		return harvestService.saveHarvest(harvest);
	}

	@DeleteMapping("/cosechas/{id}")
	public void deleteHarvestById(@PathVariable Long id) {
		harvestService.deleteById(id);
	}

	@GetMapping("/cosechas/{id}")
	public HarvestDTO findEmployee(@PathVariable Long id) {
		return harvestService.findById(id);
	}

	@GetMapping("/cosechas")
	public List<HarvestDTO> findAllEmployee() {
		return harvestService.findAll();
	}

	@PutMapping("/cosechas/{id}")
	public HarvestDTO updateEmployee(@RequestBody HarvestDTO peticion, @PathVariable Long id) {

		HarvestDTO harvestDTO = harvestService.findById(id);

		HarvestDTO harvestUpdated = null;
		if (harvestDTO != null) {

			try {
				harvestDTO.setCantidad(peticion.getCantidad());
				harvestDTO.setFecha(peticion.getFecha());
				harvestDTO.setValor(peticion.getValor());

				harvestUpdated = harvestService.saveHarvest(harvestDTO);
				return harvestUpdated;
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		}
		return harvestUpdated;
	}

}
