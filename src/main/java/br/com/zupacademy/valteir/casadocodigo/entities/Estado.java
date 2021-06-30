package br.com.zupacademy.valteir.casadocodigo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;	
	@ManyToOne
	private Pais pais;
	
	@Deprecated
	public Estado() {}
	
	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}


	public String getNome() {
		return nome;
	}

	public Boolean pertenceAoPais(Pais pais2) {
		return id.equals(pais2.getId());
	}
}
