package br.com.zupacademy.valteir.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.valteir.casadocodigo.dtos.request.ClienteRequest;
import br.com.zupacademy.valteir.casadocodigo.dtos.response.ClienteResponse;
import br.com.zupacademy.valteir.casadocodigo.entities.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@PersistenceContext
	private EntityManager em;
	
	@PostMapping
	@Transactional
	public ClienteResponse criar(@Valid @RequestBody ClienteRequest clienteRequest) {
		Cliente cliente = clienteRequest.toModel(em);
		
		em.persist(cliente);
		
		return new ClienteResponse(cliente);
	}

}
