package com.upaep.ecommerce.artesanias.constraints;

import com.upaep.ecommerce.artesanias.models.PaisModel;
import com.upaep.ecommerce.artesanias.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PaisValidator implements ConstraintValidator<PaisValid, PaisModel> {

    private PaisRepository paisRepository;

    @Autowired
    public PaisValidator(PaisRepository repository) {
        this.paisRepository = repository;
    }

    @Override
    public void initialize(PaisValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(PaisModel paisModel, ConstraintValidatorContext constraintValidatorContext) {
        return paisRepository.findById(paisModel.getId()).isPresent();
    }
}
