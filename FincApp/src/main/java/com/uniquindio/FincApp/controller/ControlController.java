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

import com.uniquindio.FincApp.dto.ControlDTO;
import com.uniquindio.FincApp.service.IControlService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/control")
public class ControlController {

	@Autowired
	private IControlService controlService;

	@PostMapping("/controles")
	public ControlDTO saveControl(@RequestBody ControlDTO control) {
		return controlService.saveControl(control);
	}

	@DeleteMapping("/controles/{idcontrol}")
	public void deleteControlById(@PathVariable Long idcontrol) {
		controlService.deleteById(idcontrol);
	}

	@GetMapping("/controles/{idcontrol}")
	public ControlDTO findControl(@PathVariable Long idcontrol) {
		return controlService.findById(idcontrol);
	}

	@GetMapping("/controles")
	public List<ControlDTO> findAllControl() {
		return controlService.findAll();
	}

	@PutMapping("/controles/{idcontrol}")
	public ControlDTO updateControl(@RequestBody ControlDTO peticion, @PathVariable Long idcontrol) {

		ControlDTO controlDTO = controlService.findById(idcontrol);

		ControlDTO controlUpdated = null;
		if (controlDTO != null) {

			try {
				controlDTO.setNombre(peticion.getNombre());
				controlDTO.setDescripcion(peticion.getDescripcion());
				controlDTO.setTipo(peticion.getTipo());
				controlDTO.setPrecio(peticion.getPrecio());
				controlDTO.setFecha(peticion.getFecha());
				
				controlUpdated = controlService.saveControl(controlDTO);
				return controlUpdated;
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		}
		return controlUpdated;
	}
	
}
