package com.ninabornemann;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    // tests for the minimal length
    @Test
    void hasMinLen_returnsFalse_when7() {
        int min = 8;
        String password = "Abc1def";
        boolean expected = false;
        boolean actual = PasswordValidator.hasMinLength(password, min);
        assertEquals(expected, actual);
    }
    @Test
    void hasMinLen_returnsTrue_when9() {
        int min = 8;
        String password = "Abc1def2g";
        boolean expected = true;
        boolean actual = PasswordValidator.hasMinLength(password, min);
        assertEquals(expected, actual);
    }
    @Test
    void hasMinLen_returnsTrue_when8() {
        int min = 8;
        String password = "Abc1defg";
        boolean expected = true;
        boolean actual = PasswordValidator.hasMinLength(password, min);
        assertEquals(expected, actual);
    }
    @Test
    void hasMinLen_throwsExeption_whenNull() {
        int min = 8;
        String password = null;
        assertThrows(IllegalArgumentException.class, () -> PasswordValidator.hasMinLength(password, min));
    }
    @Test
    void hasMinLen_throwsExeption_whenEmptyString() {
        int min = 8;
        String password = "";
        assertThrows(IllegalArgumentException.class, () -> PasswordValidator.hasMinLength(password, min));
    }

    // tests if password contains digits
    @Test
    void isDigit_returnsFalse_whenabc() {
        String password = "abc";
        boolean expected = false;
        boolean actual = PasswordValidator.containsDigit(password);
        assertEquals(expected, actual);
    }
    @Test
    void isDigit_returnsTrue_whena1bc() {
        String password = "a1bc";
        boolean expected = true;
        boolean actual = PasswordValidator.containsDigit(password);
        assertEquals(expected, actual);
    }
    @Test
    void isDigit_returnsTrue_whena1b2c3() {
        String password = "a1b2c3";
        boolean expected = true;
        boolean actual = PasswordValidator.containsDigit(password);
        assertEquals(expected, actual);
    }

    // tests if password contains Upper and Lower case characters
    @Test
    void hasUpperandLower_returnsFalse_whenOnlyUpper() {
        String password = "PASSWORT";
        boolean expected = false;
        boolean actual = PasswordValidator.containsUpperAndLower(password);
        assertEquals(expected, actual);
    }
    @Test
    void hasUpperandLower_returnsFalse_whenOnlyLower() {
        String password = "password";
        boolean expected = false;
        boolean actual = PasswordValidator.containsUpperAndLower(password);
        assertEquals(expected, actual);
    }
    @Test
    void hasUpperandLower_returnsTrue_whenMixed() {
        String password = "PassWord";
        boolean expected = true;
        boolean actual = PasswordValidator.containsUpperAndLower(password);
        assertEquals(expected, actual);
    }
    @Test
    void hasUpperandLower_returnsFalse_whenOnlyOneLetter() {
        String password = "p";
        assertFalse(PasswordValidator.containsUpperAndLower(password));
    }

    //tests if password is one of common passwords
    @Test
    void commonPassword_returnTrue_whenOneOfThem1() {
        String password = "password";
        assertTrue(PasswordValidator.isCommonPassword(password));
    }
    @Test
    void commonPassword_returnsTrue_whenOneOfThem2() {
        String password = "P4ssw0rd";
        assertTrue(PasswordValidator.containsUpperAndLower(password));

    }
    @Test
    void commonPassword_returnsFalse_whenNotCommon() {
        String password = "2DB3101B4BDB";
        assertFalse(PasswordValidator.isCommonPassword(password));
    }

    /*tests if password contains special characters
    @Test
    void hasSpecialCharacter_returnsTrue_whenContains() {
        String password = "A456B789#";
        String allowed = "";
        assertTrue(PasswordValidator.containsSpecialChar(password, allowed));
    }
    */

    //check isValid on all functions
    @Test
    void isValid_returnsFalse_when7chars() {
        String pw = "AllGood";
        assertFalse(PasswordValidator.isValid(pw));
    }
    @Test
    void isValid_returnsFalse_whenNoDigits_butCorrectLength() {
        String pw = "AllGoodA";
        assertFalse(PasswordValidator.isValid(pw));
    }
    @Test
    void isValid_returnsFalse_whenDigits_butNoUpperCase() {
        String pw = "allgood5";
        assertFalse(PasswordValidator.isValid(pw));
    }
    @Test
    void isValid_returnsFalse_whenOnlyDigits() {
        String pw = "123409764";
        assertFalse(PasswordValidator.isValid(pw));
    }
    @Test
    void isValid_returnsTrue_whenDigitsAndUpperLower() {
        String pw = "AllGood5";
        assertTrue(PasswordValidator.isValid(pw));
    }
    @Test
    void isValid_returnsFalse_whenCommonPw() {
        String pw = "P4ssW0rd";
        assertFalse(PasswordValidator.isValid(pw));
    }
    @Test
    void isValid_returnsTrue_whenAllCriteria() {
        String pw = "All4Good";
        assertTrue(PasswordValidator.isValid(pw));
    }
    @Test
    void isValid_shouldReturnTrue_AlexGuess() {
        assertTrue(PasswordValidator.isValid("aL4xcakE"));
    }

    @Test
    void isValid_shouldReturnFalse_AlexGuess() {
        assertFalse(PasswordValidator.isValid("\0aa"));
    }

    @Test
    void isValid_shouldReturnFalse_AlexNull() {
        assertThrows(IllegalArgumentException.class, () -> PasswordValidator.isValid(null));
    }

}