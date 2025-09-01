package com.ninabornemann;

import java.security.SecureRandom;

public class PasswordGenerator {

    SecureRandom random = new SecureRandom();

    public static String AllowedSpecial = "#!§$%&?+^/{}€*_-<>=";

    public String generateSecurePassword(int length, String allowedSpecials) {
        String password = "";

        // min 1 digit
        password += addDigit();

        // min 1 special character
        password += addSpecialChar(allowedSpecials);

        // 1 uppercase
        password += generateLetter().toUpperCase();

        // 1 lowercase
        password += generateLetter();

        int remaining = length - password.length();
        for (int i = 0; i < remaining; i++) {
            if (i % 4 == 0) {
                password += addSpecialChar(allowedSpecials);
            } else {
                password += generateLetter();
            }
        }

        return password;
    }

    // min 1 special character
    public String addSpecialChar(String allowedSpecials) {
        int index = this.random.nextInt(allowedSpecials.length());
        char c = allowedSpecials.charAt(index);
        return String.valueOf(c);
    }

    // min 8 characters

    // min 1 digit
    public String addDigit() {
        int digit = this.random.nextInt(9);
        String digitAsString = String.valueOf(digit);
        return digitAsString;
    }

    // min 1 uppercase and 1 lowercase
    public String generateLetter() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int index = this.random.nextInt(alphabet.length());
        char c = alphabet.charAt(index);
        return String.valueOf(c);
    }

}
