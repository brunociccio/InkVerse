package br.com.inkverse.inkverse.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoLoginValidator implements ConstraintValidator<TipoLogin, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("NOME") || value.equals("NOME COMPOSTO");
    }
    
}
