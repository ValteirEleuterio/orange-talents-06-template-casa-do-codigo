package br.com.zupacademy.valteir.casadocodigo.config.validators;

import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class DocumentValidator implements ConstraintValidator<Document, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Document doc = new Document(value);
		return doc.isValid();
	}

	private class Document {
		@CPF
		private String cpf;
		@CNPJ
		private String cnpj;
		
		public Document(String document) {
			this.cpf = document;
			this.cnpj = document;
		}
		
		public Boolean isValid() {
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			
			Set<ConstraintViolation<Document>> constraintViolations =
					  validator.validate( this );
			
			return constraintViolations.size() <= 1;
		}
	}
}
