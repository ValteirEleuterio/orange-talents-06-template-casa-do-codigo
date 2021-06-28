package br.com.zupacademy.valteir.casadocodigo.config.errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zupacademy.valteir.casadocodigo.dtos.response.ErroResponseDto;

@RestControllerAdvice
public class ValidationErrorHandler {

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroResponseDto> handle(MethodArgumentNotValidException exception) {
		BindingResult result =  exception.getBindingResult();
		
		List<ErroResponseDto> erros = new ArrayList<>();
		
		result.getFieldErrors().forEach(e -> erros.add(
				new ErroResponseDto(e.getField(),e.getDefaultMessage())));
		
		return erros;		
	}
}
