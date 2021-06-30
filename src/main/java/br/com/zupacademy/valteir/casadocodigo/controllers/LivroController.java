package br.com.zupacademy.valteir.casadocodigo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.valteir.casadocodigo.dtos.request.LivroRequest;
import br.com.zupacademy.valteir.casadocodigo.dtos.response.DetalheLivroResponse;
import br.com.zupacademy.valteir.casadocodigo.dtos.response.ErroResponse;
import br.com.zupacademy.valteir.casadocodigo.dtos.response.LivroResponse;
import br.com.zupacademy.valteir.casadocodigo.entities.Livro;
import br.com.zupacademy.valteir.casadocodigo.repositories.LivroRepository;

@RestController
@RequestMapping("/livros")
//5
public class LivroController {
	
	@Autowired
	//1
	private LivroRepository livroRepository;
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	//3
	public LivroResponse criar(@RequestBody @Valid LivroRequest livroRequest) {
		Livro livro = livroRequest.toModel(manager);
		
		livroRepository.save(livro);
		
		return new LivroResponse(livro);
	}
	
	@GetMapping
	//1
	public List<LivroResponse> listar() {
		Iterable<Livro> livros = livroRepository.findAll();
		
		List<LivroResponse> livrosResponse = new ArrayList<>();
		
		livros.forEach(l -> livrosResponse.add(new LivroResponse(l)));
		
		return livrosResponse;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {
		
		Optional<Livro> possivelLivro =  livroRepository.findById(id);
		
		if(possivelLivro.isPresent()) {
			return ResponseEntity.ok(
					new DetalheLivroResponse(possivelLivro.get())
				);
		}
		
		return ResponseEntity.badRequest()
				.body(
						new ErroResponse("Livro de id: "+ id + " não encontrado.")
				);		
	}
}
