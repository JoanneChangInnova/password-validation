package com.joanne.validation.service;

import java.util.Set;

/**
 *
 * An interface to define behaviors of validator
 *
 */
public interface Validator{

    Set<String> applyValidationRules(String value);

}
