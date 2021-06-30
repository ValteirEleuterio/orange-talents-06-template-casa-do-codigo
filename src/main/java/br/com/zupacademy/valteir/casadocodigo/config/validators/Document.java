package br.com.zupacademy.valteir.casadocodigo.config.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {DocumentValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Document {

	String message() default "Documento inválido, utilize um valor válido";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };

}
