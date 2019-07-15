package com.isoft.security.config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {UniqueColumnValidator.class}
)
public @interface UniqueColumn {
//    String message() default "{org.hibernate.validator.constraints.UniqueElements.message}";
    String message() default "unique value only allowed here";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

