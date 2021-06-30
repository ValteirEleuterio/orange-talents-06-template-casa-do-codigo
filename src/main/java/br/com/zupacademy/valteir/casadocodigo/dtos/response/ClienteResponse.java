package br.com.zupacademy.valteir.casadocodigo.dtos.response;

import br.com.zupacademy.valteir.casadocodigo.entities.Cliente;

public class ClienteResponse {
	
	private Long id;
	private String nome;
	
	public ClienteResponse(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
