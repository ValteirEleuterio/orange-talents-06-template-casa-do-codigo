package br.com.zupacademy.valteir.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.valteir.casadocodigo.dtos.request.EstadoRequest;
import br.com.zupacademy.valteir.casadocodigo.entities.Estado;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public void criar(@Valid @RequestBody EstadoRequest estadoRequest) {
		Estado estado = estadoRequest.toModel(manager);
		
		manager.persist(estado);
	}
}
