package com.passwordmanager.security;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";

    public static String generate(int length) {
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++) {
            sb.append(CHARS.charAt(rnd.nextInt(CHARS.length())));
        }
        return sb.toString();
    }
}
