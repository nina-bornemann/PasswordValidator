package com.ninabornemann;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    // tests for the minimal length
    @Test
    void hasMinLen_returnsFalse_when7() {
        int min = 8;
        String password = "Abc1def";
        boolean expected = false;
        boolean actual = Main.hasMinLength(password, min);
        assertEquals(expected, actual);
    }
    @Test
    void hasMinLen_returnsTrue_when9() {
        int min = 8;
        String password = "Abc1def2g";
        boolean expected = true;
        boolean actual = Main.hasMinLength(password, min);
        assertEquals(expected, actual);
    }
    @Test
    void hasMinLen_returnsTrue_when8() {
        int min = 8;
        String password = "Abc1defg";
        boolean expected = true;
        boolean actual = Main.hasMinLength(password, min);
        assertEquals(expected, actual);
    }
    @Test
    void hasMinLen_throwsExeption_whenNull() {
        int min = 8;
        String password = null;
        assertThrows(IllegalArgumentException.class, () -> Main.hasMinLength(password, min));
    }
    @Test
    void hasMinLen_throwsExeption_whenEmptyString() {
        int min = 8;
        String password = "";
        assertThrows(IllegalArgumentException.class, () -> Main.hasMinLength(password, min));
    }

    // tests if password contains digits
    @Test
    void isDigit_returnsFalse_whenabc() {
        String password = "abc";
        boolean expected = false;
        boolean actual = Main.containsDigit(password);
        assertEquals(expected, actual);
    }
    @Test
    void isDigit_returnsTrue_whena1bc() {
        String password = "a1bc";
        boolean expected = true;
        boolean actual = Main.containsDigit(password);
        assertEquals(expected, actual);
    }
    @Test
    void isDigit_returnsTrue_whena1b2c3() {
        String password = "a1b2c3";
        boolean expected = true;
        boolean actual = Main.containsDigit(password);
        assertEquals(expected, actual);
    }

    // tests if password contains Upper and Lower case characters
    @Test
    void hasUpperandLower_returnsFalse_whenOnlyUpper() {
        String password = "PASSWORT";
        boolean expected = false;
        boolean actual = Main.containsUpperAndLower(password);
        assertEquals(expected, actual);
    }
    @Test
    void hasUpperandLower_returnsFalse_whenOnlyLower() {
        String password = "password";
        boolean expected = false;
        boolean actual = Main.containsUpperAndLower(password);
        assertEquals(expected, actual);
    }
    @Test
    void hasUpperandLower_returnsTrue_whenMixed() {
        String password = "PassWord";
        boolean expected = true;
        boolean actual = Main.containsUpperAndLower(password);
        assertEquals(expected, actual);
    }
    @Test
    void hasUpperandLower_returnsFalse_whenOnlyOneLetter() {
        String password = "p";
        assertFalse(Main.containsUpperAndLower(password));
    }

    //tests if password is one of common passwords
    @Test
    void commonPassword_returnTrue_whenOneOfThem1() {
        String password = "password";
        assertTrue(Main.isCommonPassword(password));
    }
    @Test
    void commonPassword_returnsTrue_whenOneOfThem2() {
        String password = "P4ssw0rd";
        assertTrue(Main.containsUpperAndLower(password));

    }
    @Test
    void commonPassword_returnsFalse_whenNotCommon() {
        String password = "2DB3101B4BDB";
        assertFalse(Main.isCommonPassword(password));
    }

    /*tests if password contains special characters
    @Test
    void hasSpecialCharacter_returnsTrue_whenContains() {
        String password = "A456B789#";
        String allowed = "";
        assertTrue(Main.containsSpecialChar(password, allowed));
    }
    */

    //check isValid on all functions


}