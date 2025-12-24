package com.passwordmanager;

import com.passwordmanager.service.UserService;

public class Main {

    public static void main(String[] args) {

        UserService service = new UserService();

        System.out.println("Register: " + service.register("ankur", "Secret@123"));
        System.out.println("Login correct: " + service.login("ankur", "Secret@123"));
        System.out.println("Login wrong: " + service.login("ankur", "wrong"));
    }
}
