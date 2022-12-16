package com.joanne.validation.service;

import com.joanne.validation.common.enums.InputType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ValidatorFactory Tester.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PasswordValidator.class, ValidatorFactory.class, ValidationRules.class})
public class ValidatorFactoryTest {

    @Autowired
    ValidatorFactory validatorFactory;


    @Test
    public void testGetValidator() throws Exception {
        Validator passwordValidator = validatorFactory.getValidator(InputType.PASSWORD);
        Assert.assertNotNull(passwordValidator);
    }


} 
