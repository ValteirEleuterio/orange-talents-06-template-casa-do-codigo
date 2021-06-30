package br.com.zupacademy.valteir.casadocodigo.config.errors;

public class ServiceException extends RuntimeException {

	public ServiceException(String mensagem) {
		super(mensagem);
	}

}
