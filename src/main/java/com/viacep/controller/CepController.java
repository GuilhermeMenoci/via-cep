package com.viacep.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viacep.model.CepVO;
import com.viacep.service.CepService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ceps")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class CepController {

	private final CepService service;
	
	@GetMapping("/{cep}")
	public CepVO getCep(@PathVariable String cep) throws Exception {
		return service.getCep(cep);
	}
	
}
