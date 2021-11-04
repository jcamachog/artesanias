package com.upaep.ecommerce.artesanias.constraints;

import com.upaep.ecommerce.artesanias.models.ArtesaniaModel;
import com.upaep.ecommerce.artesanias.repositories.ArtesaniaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ArtesaniaValidator implements ConstraintValidator<ArtesaniaValid, ArtesaniaModel> {

    ArtesaniaRepository artesaniaRepository;

    @Autowired
    public ArtesaniaValidator(ArtesaniaRepository artesaniaRepository) {
        this.artesaniaRepository = artesaniaRepository;
    }

    @Override
    public void initialize(ArtesaniaValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(ArtesaniaModel artesaniaModel, ConstraintValidatorContext constraintValidatorContext) {
        return artesaniaRepository.findById(artesaniaModel.getId()).isPresent();
    }
}
