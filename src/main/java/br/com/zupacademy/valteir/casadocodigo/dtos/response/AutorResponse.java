package br.com.zupacademy.valteir.casadocodigo.dtos.response;

import br.com.zupacademy.valteir.casadocodigo.entities.Autor;

public class AutorResponse {

	private Long id;
	private String nome;

	public AutorResponse(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
