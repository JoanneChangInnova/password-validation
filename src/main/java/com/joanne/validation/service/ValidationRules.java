package com.joanne.validation.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.IntPredicate;
import java.util.regex.Pattern;

/**
 *
 * This class provides rules for validators to apply.
 *
 */
@Component
public class ValidationRules {

    public boolean isEmpty(String value) {
        if(value == null || value.trim().isEmpty()){
            return true;
        }
        return false;
    }

    public boolean containsSpecialCharacter(String value){
        return (Pattern.compile("[^A-Za-z0-9 ]").matcher(value).find());
    }

    public boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }

    public boolean containsLowerCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }

    public boolean containsUpperCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    public boolean containsNumber(String value) {
        return contains(value, Character::isDigit);
    }

    public boolean isLengthValid(String value, int max, int min){
        return (value.length()>=min && value.length()<=max);
    }

    public boolean containsSameSequence(String value){
        for (int i = 0; i < value.length(); i++) {
            char charAt = value.charAt(i);
            int nextIndex = value.indexOf(charAt, i + 1);
            while (nextIndex != -1) {
                String s1 = value.substring(i, nextIndex);
                if (2 * nextIndex - i <= value.length()) {
                    String s2 = value.substring(nextIndex, 2 * nextIndex - i);
                    if (s1.equals(s2)) {
                        return true;
                    }
                }
                nextIndex = value.indexOf(charAt, nextIndex + 1);
            }

        }
        return false;
    }
}
