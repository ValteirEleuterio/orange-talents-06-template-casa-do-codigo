package br.com.zupacademy.valteir.casadocodigo.dtos.request;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zupacademy.valteir.casadocodigo.config.validators.Document;
import br.com.zupacademy.valteir.casadocodigo.config.validators.ExistingId;
import br.com.zupacademy.valteir.casadocodigo.config.validators.UniqueValue;
import br.com.zupacademy.valteir.casadocodigo.entities.Cliente;
import br.com.zupacademy.valteir.casadocodigo.entities.Estado;
import br.com.zupacademy.valteir.casadocodigo.entities.Pais;

public class ClienteRequest {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@Document
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ExistingId(domainClass = Pais.class, fieldName = "id")
	private Long paisId;
	private Long estadoId;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;

	public ClienteRequest(String email, String nome, String sobrenome, String documento, String endereco,
			String complemento, String cidade, Long paisId, Long estadoId, String telefone, String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente toModel(EntityManager em) {
		Pais pais = em.find(Pais.class, paisId);
		
		Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone,
				cep);

		if (estadoId != null) {
			Estado estado = em.find(Estado.class, estadoId);
			Assert.state(estado != null, "Estado de id: " + estadoId + " não encontrado.");
			cliente.setEstado(estado);
		}
		
		return cliente;
	}

}
