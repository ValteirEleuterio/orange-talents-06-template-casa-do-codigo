package br.com.zupacademy.valteir.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.valteir.casadocodigo.dtos.request.PaisRequest;
import br.com.zupacademy.valteir.casadocodigo.entities.Pais;
import br.com.zupacademy.valteir.casadocodigo.repositories.PaisRepository;

@RestController
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public void criar(@Valid @RequestBody PaisRequest paisRequest) {
		Pais pais = paisRequest.toModel();
		
		paisRepository.save(pais);
	}
}
