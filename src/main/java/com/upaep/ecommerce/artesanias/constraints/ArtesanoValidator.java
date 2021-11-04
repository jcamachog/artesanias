package com.upaep.ecommerce.artesanias.constraints;

import com.upaep.ecommerce.artesanias.models.ArtesanoModel;
import com.upaep.ecommerce.artesanias.repositories.ArtesanoRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ArtesanoValidator implements ConstraintValidator<ArtesanoValid, ArtesanoModel> {

    private ArtesanoRepository artesanoRepository;

    public ArtesanoValidator(ArtesanoRepository repository){
        this.artesanoRepository = repository;
    }

    @Override
    public void initialize(ArtesanoValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(ArtesanoModel artesanoModel, ConstraintValidatorContext constraintValidatorContext) {
        return artesanoRepository.findById(artesanoModel.getId()).isPresent();
    }
}
