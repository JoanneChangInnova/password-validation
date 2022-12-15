package com.joanne.validation.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * ValidationRules Tester.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration(classes = {ValidationRules.class})
public class ValidationRulesTest {

    @Autowired
    ValidationRules validationRules;

    @Test
    public void testIsEmpty(){
        List<String> testCases = List.of(""," ");
        testCases.forEach(r->Assert.assertTrue(validationRules.isEmpty(r)));
        Assert.assertTrue(validationRules.isEmpty(null));
        Assert.assertFalse(validationRules.isEmpty("null"));
    }

    @Test
    public void testContainsSpecialCharacter(){
        String testCase1 = "!@#$%%^&*ABC";
        Assert.assertTrue(validationRules.containsSpecialCharacter(testCase1));
        String testCase2 = "abcDEFG123";
        Assert.assertFalse(validationRules.containsSpecialCharacter(testCase2));
    }

    @Test
    public void testContains() {
        Assert.assertTrue(validationRules.contains("test",i -> Character.isLetter(i)));
    }

    @Test
    public void testContainsLowerCase() throws Exception {
        Assert.assertTrue(validationRules.containsLowerCase("tEst"));
        Assert.assertFalse(validationRules.containsLowerCase("TEST"));
    }


    @Test
    public void testContainsUpperCase() throws Exception {
        Assert.assertTrue(validationRules.containsUpperCase("Test"));
        Assert.assertFalse(validationRules.containsUpperCase("test"));
    }

    @Test
    public void testContainsNumber(){
        Assert.assertTrue(validationRules.containsNumber("123Test"));
        Assert.assertFalse(validationRules.containsNumber("test"));
    }

    @Test
    public void testIsLengthValid(){
        Assert.assertTrue(validationRules.isLengthValid("123",3,1));
        Assert.assertFalse(validationRules.isLengthValid("1234",3,1));
    }

    @Test
    public void testContainsSameSequence() {
        List<String> containsSameSequence = List.of("11a11","ABCCBA","abcd9abab","abab9494","ABZZO");
        containsSameSequence.forEach(r->Assert.assertTrue(validationRules.containsSameSequence(r)));
        List<String> containsNoSequence = List.of("12a12","123qs","!@#f$#@","ABCDCBA","2AbA2");
        containsNoSequence.forEach(r->Assert.assertFalse(validationRules.containsSameSequence(r)));
    }


}
