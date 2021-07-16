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

import com.uniquindio.FincApp.dto.EmployeeDTO;
import com.uniquindio.FincApp.dto.PositionDTO;
import com.uniquindio.FincApp.service.IPositionService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/position")
public class PositionController {

	@Autowired
	private IPositionService positionService;

	@PostMapping("/cargos")
	public PositionDTO savePosition(@RequestBody PositionDTO position) {
		return positionService.savePosition(position);
	}

	@DeleteMapping("/cargos/{idcargo}")
	public void deletePositionById(@PathVariable Long idcargo) {
		positionService.deleteById(idcargo);
	}

	@GetMapping("/cargos/{idcargo}")
	public PositionDTO findPosition(@PathVariable Long idcargo) {
		return positionService.findById(idcargo);
	}

	@GetMapping("/cargos")
	public List<PositionDTO> findAllPosition() {
		return positionService.findAll();
	}

	@PutMapping("/cargos/{idcargo}")
	public PositionDTO updateEmployee(@RequestBody PositionDTO peticion, @PathVariable Long idcargo) {

		PositionDTO positionDTO = positionService.findById(idcargo);

		PositionDTO positionUpdated = null;
		if (positionDTO != null) {

			try {
				positionDTO.setTipoCargo(peticion.getTipoCargo());			
				positionDTO.setTrabajadorCedula(peticion.getTrabajadorCedula());

				positionUpdated = positionService.savePosition(positionDTO);
				return positionUpdated;
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		}
		return positionUpdated;
	}
	
}
