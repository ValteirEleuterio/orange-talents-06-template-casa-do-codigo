package br.com.zupacademy.valteir.casadocodigo.dtos.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zupacademy.valteir.casadocodigo.config.validators.UniqueValue;
import br.com.zupacademy.valteir.casadocodigo.entities.Pais;

public class PaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public PaisRequest(String nome) {
		this.nome = nome;
	}
	
	public Pais toModel() {
		return new Pais(nome);
	}
}
