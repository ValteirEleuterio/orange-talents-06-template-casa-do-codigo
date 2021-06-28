package br.com.zupacademy.valteir.casadocodigo.dtos.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.valteir.casadocodigo.entities.Categoria;

public class CategoriaRequest {
	
	@NotBlank
	private String nome;
	
	public CategoriaRequest(@JsonProperty("nome") String nome) {
		this.nome = nome;
	}
	
	public Categoria toModel() {
		return new Categoria(this.nome);
	}

	public String getNome() {
		return nome;
	}

}
