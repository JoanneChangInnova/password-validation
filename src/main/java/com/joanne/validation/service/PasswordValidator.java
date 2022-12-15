package com.joanne.validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * A concrete class that implements the validator behaviors for password
 *
 */
@Service
public class PasswordValidator implements Validator {

    @Autowired
    ValidationRules validationRules;

//    声明为私有、静态、final类型的了。有什么原因呢？首先日志记录器应当是一个类内部的东西，不允许其子类或者其他类使用因此被private修饰为私有的。再其次，对于所有该类的对象也就是该类的所有实例只需要一个logger所以使用static修饰。且logger不能被替换或者修改、所以使用final再做修饰。
    private static final String PASSWORD_FAILED_LETTER_NUMBER = "Password must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.";

    private static final String PASSWORD_FAILED_LENGTH = "Password must be between 5 and 12 characters in length.";

    private static final String PASSWORD_FAILED_SEQUENCE = "Password must not contain any sequence of characters immediately followed by the same sequence.";


    @Override
    public Set<String> applyValidationRules(String password) {
        Set<String> validationMessages = new HashSet<>();
        if(validationRules.isEmpty(password)){
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
        if(!validationRules.isLengthValid(password,12,5)){
            validationMessages.add(PASSWORD_FAILED_LENGTH);
        }
        if(validationRules.containsSameSequence(password)){
            validationMessages.add(PASSWORD_FAILED_SEQUENCE);
        }
        return validationMessages;
    }

}

