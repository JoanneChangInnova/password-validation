package com.joanne.validation.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;
/**
 * PasswordValidator Tester.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration(classes = {PasswordValidator.class, ValidationRules.class})
public class PasswordValidatorTest {

    @Autowired
    PasswordValidator passwordValidator;

    @Test
    public void testApplyValidationRules() {
        String inValidpassword = "AA";
        Set<String> testCase1 = passwordValidator.applyValidationRules(inValidpassword);
        Assert.assertTrue(testCase1.size()==3);
        String validPassword = "123456a";
        Set<String> testCase2 = passwordValidator.applyValidationRules(validPassword);
        Assert.assertFalse(testCase2.size()==3);
        //Assert.assertEquals();
    }
}