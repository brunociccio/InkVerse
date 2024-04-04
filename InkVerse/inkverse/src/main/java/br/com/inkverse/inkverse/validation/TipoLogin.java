package br.com.inkverse.inkverse.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoLoginValidator.class)
public @interface TipoLogin {

    String message() default "{login.tipo.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
