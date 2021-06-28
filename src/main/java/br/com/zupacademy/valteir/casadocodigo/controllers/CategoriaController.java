package br.com.zupacademy.valteir.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.valteir.casadocodigo.dtos.request.CategoriaRequest;
import br.com.zupacademy.valteir.casadocodigo.dtos.response.CategoriaResponse;
import br.com.zupacademy.valteir.casadocodigo.entities.Categoria;
import br.com.zupacademy.valteir.casadocodigo.repositories.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
		
	@PostMapping
	public CategoriaResponse criar(@RequestBody @Valid CategoriaRequest categoriaRequest) {
		
		Categoria categoria = categoriaRequest.toModel();
		
		categoriaRepository.save(categoria);
		
		return new CategoriaResponse(categoria);		
	}
}
