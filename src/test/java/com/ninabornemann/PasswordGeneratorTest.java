package com.ninabornemann;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {

    @Test
    void isRandomDigit_returnsTrue() {
        PasswordGenerator generator = new PasswordGenerator();
        String actual = generator.addDigit();
        System.out.println(actual);
        assertTrue(Character.isDigit(actual.charAt(0)));
        assertTrue(actual.length() == 1);
    }

    @Test
    void isPasswordCorrect_returnsTrue() {
        PasswordGenerator generator = new PasswordGenerator();
        String actual = generator.generateSecurePassword(8, PasswordGenerator.AllowedSpecial);
        System.out.println(actual);
        assertTrue(PasswordValidator.isValid(actual));
    }

}