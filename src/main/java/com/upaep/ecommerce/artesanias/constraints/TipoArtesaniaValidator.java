package com.upaep.ecommerce.artesanias.constraints;

import com.upaep.ecommerce.artesanias.entities.TipoArtesania;
import com.upaep.ecommerce.artesanias.models.TipoArtesaniaModel;
import com.upaep.ecommerce.artesanias.repositories.TipoArtesaniaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TipoArtesaniaValidator implements ConstraintValidator<TipoArtesaniaValid, TipoArtesaniaModel> {

    TipoArtesaniaRepository tipoArtesaniaRepository;

    @Autowired
    public TipoArtesaniaValidator(TipoArtesaniaRepository repository) {
        tipoArtesaniaRepository = repository;
    }

    @Override
    public void initialize(TipoArtesaniaValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(TipoArtesaniaModel tipoArtesaniaModel, ConstraintValidatorContext constraintValidatorContext) {
        return tipoArtesaniaRepository.findById(tipoArtesaniaModel.getId()).isPresent();
    }
}
