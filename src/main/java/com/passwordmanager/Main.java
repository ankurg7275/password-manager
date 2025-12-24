package com.passwordmanager;

import com.passwordmanager.service.*;
import com.passwordmanager.model.PasswordEntry;
import com.passwordmanager.security.PasswordGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        VaultService vaultService = new VaultService();

        System.out.println("=== Secure Password Manager ===");

        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Master Password: ");
        String masterPassword = sc.nextLine();

        if (!userService.login(user, masterPassword)) {
            System.out.println("User not found. Registering...");
            userService.register(user, masterPassword);
        }

        while (true) {
            System.out.println("\n1. Add Password");
            System.out.println("2. List Passwords");
            System.out.println("3. Generate Password");
            System.out.println("4. Exit");

            System.out.print("Choice: ");
            int ch = Integer.parseInt(sc.nextLine());

            if (ch == 1) {
                System.out.print("Site: ");
                String site = sc.nextLine();

                System.out.print("Username: ");
                String uname = sc.nextLine();

                System.out.print("Password: ");
                String pwd = sc.nextLine();

                System.out.print("Expiry (YYYY-MM-DD or empty): ");
                String exp = sc.nextLine();
                LocalDate expiry = exp.isEmpty() ? null : LocalDate.parse(exp);

                vaultService.addPassword(user, masterPassword, site, uname, pwd, expiry);
                System.out.println("Saved.");
            }

            else if (ch == 2) {
                List<PasswordEntry> entries = vaultService.listPasswords(user);

                for (PasswordEntry e : entries) {
                    String pwd = vaultService.decryptPassword(e, masterPassword);
                    System.out.println("\nSite: " + e.getSite());
                    System.out.println("User: " + e.getUsername());
                    System.out.println("Password: " + pwd);

                    if (vaultService.isExpired(e))
                        System.out.println("⚠ EXPIRED");
                }
            }

            else if (ch == 3) {
                String gen = PasswordGenerator.generate(12);
                System.out.println("Generated Password: " + gen);
            }

            else {
                break;
            }
        }
    }
}
