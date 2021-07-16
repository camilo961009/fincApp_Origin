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
import com.uniquindio.FincApp.dto.InsumoDTO;
import com.uniquindio.FincApp.service.IInsumoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/insumo")
public class InsumoController {

	@Autowired
	private IInsumoService insumoService;

	@PostMapping("/insumos")
	public InsumoDTO saveInsumo(@RequestBody InsumoDTO insumo) {
		return insumoService.saveInsumo(insumo);
	}

	@DeleteMapping("/insumos/{idinsumo}")
	public void deleteInsumoById(@PathVariable Long idinsumo) {
		insumoService.deleteById(idinsumo);
	}

	@GetMapping("/insumos/{idinsumo}")
	public InsumoDTO findInsumo(@PathVariable Long idinsumo) {
		return insumoService.findById(idinsumo);
	}

	@GetMapping("/insumos")
	public List<InsumoDTO> findAllInsumo() {
		return insumoService.findAll();
	}

	@PutMapping("/insumos/{idinsumo}")
	public InsumoDTO updateInsumo(@RequestBody InsumoDTO peticion, @PathVariable Long idinsumo) {

		InsumoDTO insumoDTO = insumoService.findById(idinsumo);

		InsumoDTO insumoUpdated = null;
		if (insumoDTO != null) {

			try {
				insumoDTO.setNombre(peticion.getNombre());
				insumoDTO.setTipo(peticion.getTipo());
				insumoDTO.setCantidad(peticion.getCantidad());
				insumoDTO.setPrecio(peticion.getPrecio());

				insumoUpdated = insumoService.saveInsumo(insumoDTO);
				return insumoUpdated;
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		}
		return insumoUpdated;
	}

}
