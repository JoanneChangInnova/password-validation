package com.joanne.validation.service;

import com.joanne.validation.common.model.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * This class executes the validation that applies to the selected validator.
 *
 */
@Service
public class ValidationService {

    @Autowired
    ValidatorFactory validatorFactory;

    public boolean validate(Input input){
        Validator validator = validatorFactory.getValidator(input.getType());
        Set<String> validationMessages = validator.applyValidationRules(input.getValue());
        return (validationMessages.isEmpty()) ? true : false;
    }

}
