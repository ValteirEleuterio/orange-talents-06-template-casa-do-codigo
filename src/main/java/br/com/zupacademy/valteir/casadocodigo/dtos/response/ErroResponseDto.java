package br.com.zupacademy.valteir.casadocodigo.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErroResponseDto {

	private String campo;
	private String mensagem;
	
	public ErroResponseDto(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}
	
	public ErroResponseDto(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getCampo() {
		return campo;
	}
	public String getMensagem() {
		return mensagem;
	}
	
	
}
