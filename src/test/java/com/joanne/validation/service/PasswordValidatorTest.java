package com.joanne.validation.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * PasswordValidator Tester.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PasswordValidator.class, ValidationRules.class})
public class PasswordValidatorTest {

    @Autowired
    PasswordValidator passwordValidator;

    @Test
    public void testApplyValidationRules() {
        String validPassword = "123456a";
        Set<String> testCase1 = passwordValidator.applyValidationRules(validPassword);
        Assert.assertTrue(testCase1.size() == 0);

        String violateTwoRules = "A1b#";
        Set<String> testCase2 = passwordValidator.applyValidationRules(violateTwoRules);
        Assert.assertTrue(testCase2.size() == 2);
        Assert.assertEquals(testCase2, Set.of(passwordValidator.PASSWORD_FAILED_LETTER_NUMBER,
                passwordValidator.PASSWORD_FAILED_LENGTH));

        String inValidpassword = "AAA1";
        Set<String> testCase3 = passwordValidator.applyValidationRules(inValidpassword);
        Assert.assertEquals(testCase3, Set.of(passwordValidator.PASSWORD_FAILED_LETTER_NUMBER,
                passwordValidator.PASSWORD_FAILED_LENGTH, passwordValidator.PASSWORD_FAILED_SEQUENCE));

    }
}