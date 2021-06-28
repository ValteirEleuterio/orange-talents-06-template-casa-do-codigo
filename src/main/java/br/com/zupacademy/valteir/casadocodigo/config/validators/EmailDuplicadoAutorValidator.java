package br.com.zupacademy.valteir.casadocodigo.config.validators;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.valteir.casadocodigo.dtos.request.AutorRequest;
import br.com.zupacademy.valteir.casadocodigo.entities.Autor;
import br.com.zupacademy.valteir.casadocodigo.repositories.AutorRepository;

@Component
public class EmailDuplicadoAutorValidator implements Validator{

	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors())
			return;
		
		AutorRequest request = (AutorRequest) target;
		
		Optional<Autor> possivelAutor =  autorRepository.findByEmail(request.getEmail());
		
		if(possivelAutor.isPresent()) {
			errors.rejectValue(
					"email", null, 
					"Já existe um autor(a) com o mesmo email " 
					+ request.getEmail()
			);
		}
	}

}
