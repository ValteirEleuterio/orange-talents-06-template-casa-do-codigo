package br.com.zupacademy.valteir.casadocodigo.config.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
	
	String message() default "Já existe um registro cadastrado no sistema";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
	
	String fieldName();
	
	Class<?> domainClass();

}
