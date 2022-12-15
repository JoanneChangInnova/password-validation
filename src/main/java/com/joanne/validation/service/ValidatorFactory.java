package com.joanne.validation.service;

import com.joanne.validation.common.enums.InputType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * This class selects the correct validator at runtime.
 *
 */
@Component
public class ValidatorFactory {

    @Autowired
    PasswordValidator passwordValidator;

    public Validator getValidator(InputType type){
        return type.equals(InputType.PASSWORD) ? passwordValidator: null;
    }
}
