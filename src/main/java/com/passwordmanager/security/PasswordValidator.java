package com.passwordmanager.security;

public class PasswordValidator {

    public static boolean isStrong(String password) {
        return password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}");
    }
}
