package br.com.zupacademy.valteir.casadocodigo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.util.Assert;


@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String nome;
	private String sobrenome;
	private String documento;
	private String endereco;
	private String complemento;
	private String cidade;
	@ManyToOne
	private Pais pais;
	@ManyToOne
	private Estado estado;
	private String telefone;
	private String cep;

	@Deprecated
	private Cliente() {
	}

	public Cliente(String email, String nome, String sobrenome, String documento, String endereco,
			String complemento, String cidade, Pais pais, String telefone, String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
	}

	public void setEstado(Estado estado) {
		Assert.state(estado.pertenceAoPais(this.pais), "Estado "+ estado.getNome() + " não pertence ao pais " + pais.getNome());
		
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
