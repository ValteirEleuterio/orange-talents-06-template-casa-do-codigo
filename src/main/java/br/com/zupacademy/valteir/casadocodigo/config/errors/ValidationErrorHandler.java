package br.com.zupacademy.valteir.casadocodigo.config.errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zupacademy.valteir.casadocodigo.dtos.response.ErroResponse;

@RestControllerAdvice
public class ValidationErrorHandler {

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroResponse> handle(MethodArgumentNotValidException exception) {
		BindingResult result =  exception.getBindingResult();
		
		List<ErroResponse> erros = new ArrayList<>();
		
		result.getFieldErrors().forEach(e -> erros.add(
				new ErroResponse(e.getField(),e.getDefaultMessage())));
		
		return erros;		
	}
}
