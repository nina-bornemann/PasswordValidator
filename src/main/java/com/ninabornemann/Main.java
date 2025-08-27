package com.ninabornemann;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");
    }

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

    /* Bonus:
    public static boolean containsSpecialChar(String password, String allowed) {
        return true;
    }
    */

    // Optionale Gesamtsicht:
    // nutzt die obenstehenden Checks

}
