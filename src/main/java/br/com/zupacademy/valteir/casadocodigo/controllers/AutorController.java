package br.com.zupacademy.valteir.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.valteir.casadocodigo.config.validators.EmailDuplicadoAutorValidator;
import br.com.zupacademy.valteir.casadocodigo.dtos.request.AutorRequest;
import br.com.zupacademy.valteir.casadocodigo.dtos.response.AutorResponse;
import br.com.zupacademy.valteir.casadocodigo.entities.Autor;
import br.com.zupacademy.valteir.casadocodigo.repositories.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private EmailDuplicadoAutorValidator emailDuplicadoAutorValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(emailDuplicadoAutorValidator);
	}
	
	@PostMapping
	public AutorResponse criar(@RequestBody @Valid AutorRequest autorRequest) {
		
		Autor autor = autorRequest.toModel();
		
		autorRepository.save(autor);	
		
		return new AutorResponse(autor);
	}
}
