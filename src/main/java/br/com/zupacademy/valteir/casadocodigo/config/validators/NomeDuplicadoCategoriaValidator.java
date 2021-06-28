package br.com.zupacademy.valteir.casadocodigo.config.validators;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.valteir.casadocodigo.dtos.request.CategoriaRequest;
import br.com.zupacademy.valteir.casadocodigo.entities.Categoria;
import br.com.zupacademy.valteir.casadocodigo.repositories.CategoriaRepository;

@Component
public class NomeDuplicadoCategoriaValidator implements Validator {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors())
			return;
		
		CategoriaRequest request = (CategoriaRequest) target;
		
		Optional<Categoria> possivelCategoria = categoriaRepository
				.findByNome(request.getNome());
		
		if(possivelCategoria.isPresent()) {
			errors.rejectValue(
					"nome", 
					null, 
					"Já existe uma categoria com o mesmo nome " 
					+ request.getNome()
			);
		}
		
	}

}
