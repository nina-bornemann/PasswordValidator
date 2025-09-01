package com.ninabornemann;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter your password: ");
        Scanner input = new Scanner(System.in);

        String password = input.nextLine();
        PasswordValidator.isValid(password);
    }
}
