package br.com.zupacademy.valteir.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.valteir.casadocodigo.dtos.request.LivroRequest;
import br.com.zupacademy.valteir.casadocodigo.dtos.response.LivroResponse;
import br.com.zupacademy.valteir.casadocodigo.entities.Livro;
import br.com.zupacademy.valteir.casadocodigo.repositories.LivroRepository;

@RestController
@RequestMapping("/livros")
//4
public class LivroController {
	
	@Autowired
	//1
	LivroRepository livroRepository;

	@PostMapping
	//3
	public LivroResponse criar(@RequestBody @Valid LivroRequest livroRequest) {
		Livro livro = livroRequest.toModel();
		
		livroRepository.save(livro);
		
		return new LivroResponse(livro);
	}
}
