package br.com.zupacademy.valteir.casadocodigo.dtos.response;

import br.com.zupacademy.valteir.casadocodigo.entities.Autor;

public class DetalheAutorResponse {
	
	private String nome;
	private String descricao;
	
	public DetalheAutorResponse(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
}
