package com.upaep.ecommerce.artesanias.constraints;

import com.upaep.ecommerce.artesanias.repositories.ArtesanoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CorreoArtesanoValidator implements ConstraintValidator<CorreoArtesanoValid, String> {

    private ArtesanoRepository artesanoRepository;

    @Autowired
    public CorreoArtesanoValidator(ArtesanoRepository artesanoRepository) {
        this.artesanoRepository = artesanoRepository;
    }

    @Override
    public void initialize(CorreoArtesanoValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(artesanoRepository.findByCorreoElectronico(s) == null)
            return true;

        return false;
    }
}
