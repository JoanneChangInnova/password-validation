package com.joanne.validation.service;

import com.joanne.validation.common.enums.InputType;
import com.joanne.validation.common.model.Input;
import com.joanne.validation.service.PasswordValidator;
import com.joanne.validation.service.ValidationRules;
import com.joanne.validation.service.ValidatorFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* ValidationService Tester.
*/
@RunWith( SpringRunner.class )
@ContextConfiguration(classes = {ValidationService.class, PasswordValidator.class, ValidatorFactory.class, ValidationRules.class})
public class ValidationServiceTest {

    @Autowired
    ValidationService validationService;

@Before
public void before() throws Exception {
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: validate(Input input) 
* 
*/ 
@Test
public void testValidate() throws Exception {
    Input input = new Input(InputType.PASSWORD,"123456a");
    boolean valid = validationService.validate(input);
    Assert.assertTrue(valid);
    Input input2 = new Input(InputType.PASSWORD,"ABC@#$123");
    boolean notValid = validationService.validate(input2);
    Assert.assertFalse(notValid);
} 


} 
