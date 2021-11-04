package com.upaep.ecommerce.artesanias.constraints;


import com.upaep.ecommerce.artesanias.repositories.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CorreoCompradorValidator implements ConstraintValidator<CorreoCompradorValid, String> {

    private CompradorRepository compradorRepository;

    @Autowired
    public CorreoCompradorValidator(CompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }

    @Override
    public void initialize(CorreoCompradorValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(compradorRepository.findByCorreoElectronico(s) == null)
            return true;

        return false;
    }
}
