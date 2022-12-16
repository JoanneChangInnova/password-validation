package com.joanne.validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * A concrete class that implements the validator behaviors for password
 */
@Service
public class PasswordValidator implements Validator {

    @Autowired
    ValidationRules validationRules;

    public static final String PASSWORD_FAILED_LETTER_NUMBER = "Password must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.";

    public static final String PASSWORD_FAILED_LENGTH = "Password must be between 5 and 12 characters in length.";

    public static final String PASSWORD_FAILED_SEQUENCE = "Password must not contain any sequence of characters immediately followed by the same sequence.";


    @Override
    public Set<String> applyValidationRules(String password) {
        Set<String> validationMessages = new HashSet<>();
        if (validationRules.isEmpty(password)) {
            validationMessages.add(PASSWORD_FAILED_LETTER_NUMBER);
        }
        if (!validationRules.containsLowerCase(password)) {
            validationMessages.add(PASSWORD_FAILED_LETTER_NUMBER);
        }
        if (!validationRules.containsNumber(password)) {
            validationMessages.add(PASSWORD_FAILED_LETTER_NUMBER);
        }
        if (validationRules.containsUpperCase(password)) {
            validationMessages.add(PASSWORD_FAILED_LETTER_NUMBER);
        }
        if (validationRules.containsSpecialCharacter(password)) {
            validationMessages.add(PASSWORD_FAILED_LETTER_NUMBER);
        }
        if (!validationRules.isLengthValid(password, 12, 5)) {
            validationMessages.add(PASSWORD_FAILED_LENGTH);
        }
        if (validationRules.containsSameSequence(password)) {
            validationMessages.add(PASSWORD_FAILED_SEQUENCE);
        }
        return validationMessages;
    }

}

