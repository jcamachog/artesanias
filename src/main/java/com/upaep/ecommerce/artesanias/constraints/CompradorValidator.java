package com.upaep.ecommerce.artesanias.constraints;

import com.upaep.ecommerce.artesanias.models.CompradorModel;
import com.upaep.ecommerce.artesanias.repositories.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompradorValidator implements ConstraintValidator<CompradorValid, CompradorModel> {

    CompradorRepository compradorRepository;

    @Autowired
    public CompradorValidator(CompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }

    @Override
    public void initialize(CompradorValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(CompradorModel compradorModel, ConstraintValidatorContext constraintValidatorContext) {
        return compradorRepository.findById(compradorModel.getId()).isPresent();
    }
}
