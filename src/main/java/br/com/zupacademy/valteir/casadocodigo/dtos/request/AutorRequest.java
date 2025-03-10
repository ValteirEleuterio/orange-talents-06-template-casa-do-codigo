package br.com.zupacademy.valteir.casadocodigo.dtos.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.valteir.casadocodigo.config.validators.UniqueValue;
import br.com.zupacademy.valteir.casadocodigo.entities.Autor;

public class AutorRequest {

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorRequest(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

	public String getEmail() {
		return email;
	}
}
