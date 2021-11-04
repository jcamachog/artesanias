package com.upaep.ecommerce.artesanias.constraints;

import com.upaep.ecommerce.artesanias.models.MonedaModel;
import com.upaep.ecommerce.artesanias.repositories.MonedaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MonedaValidator implements ConstraintValidator<MonedaValid, MonedaModel> {

    MonedaRepository monedaRepository;

    @Autowired
    public MonedaValidator(MonedaRepository repository) {
        monedaRepository = repository;
    }

    @Override
    public void initialize(MonedaValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(MonedaModel monedaModel, ConstraintValidatorContext constraintValidatorContext) {
        return monedaRepository.findById(monedaModel.getId()).isPresent();
    }
}
