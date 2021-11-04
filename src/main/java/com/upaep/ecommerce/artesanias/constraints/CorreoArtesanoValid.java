package com.upaep.ecommerce.artesanias.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, FIELD, ANNOTATION_TYPE, METHOD, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = CorreoArtesanoValidator.class)
@Documented
public @interface CorreoArtesanoValid {
    String message() default "{com.upaep.ecommerce.artesanias.constraints.CorreoArtesanoValid.message}";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
