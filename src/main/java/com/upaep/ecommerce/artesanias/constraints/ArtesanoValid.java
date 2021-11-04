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
@Constraint(validatedBy = ArtesanoValidator.class)
@Documented
public @interface ArtesanoValid {
    String message() default "{com.upaep.ecommerce.artesanias.constraints.ArtesanoValid.message}";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
