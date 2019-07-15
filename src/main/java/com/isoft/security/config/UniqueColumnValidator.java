package com.isoft.security.config;

import com.isoft.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueColumnValidator implements ConstraintValidator<UniqueColumn, Object> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(UniqueColumn constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(userRepository==null)
            return true;
        return userRepository.findUserByUsername(o.toString()) == null;
    }

}
