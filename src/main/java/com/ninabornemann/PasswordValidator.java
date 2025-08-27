package com.ninabornemann;

import java.util.List;
import java.util.Locale;

public class PasswordValidator {
    public static boolean hasMinLength(String password, int min) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (password.length() < min) {
            return false;
        }
        return true;
    }

    public static boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUpperAndLower(String password) {
        if (password.equals(password.toUpperCase()) || password.equals(password.toLowerCase())) {
            return false;
        }
        return true;
    }

    // kleine interne Liste
    public static boolean isCommonPassword(String password) {
        String p = password == null ? "" : password.trim().toLowerCase(Locale.ROOT);
        String[] common = {"password", "password1", "12345678", "Aa345678", "P4ssw0rd"};
        for (String word : common) {
            if (p.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }

    //Bonus: Special characters
    public static boolean containsSpecialChar(String password, String allowed) {

        for (char cp : password.toCharArray()) {
            for (char ca : allowed.toCharArray()) {
                if (ca == cp) {
                    return true;
                }
            }
        }
        return false;
    }

    // Optionale Gesamtsicht:
    // nutzt die obenstehenden Checks
    public static boolean isValid(String password) {
        if (!hasMinLength(password, 8)) {
            return false;
        } else if (!containsDigit(password)) {
            return false;
        } else if (!containsUpperAndLower(password)) {
            return false;
        } else if (isCommonPassword(password)) {
            return false;
        } else if (!containsSpecialChar(password, "#!§$%&?+^/{}€*_-<>=")) {
            return false;
        }
        return true;
    }
}
