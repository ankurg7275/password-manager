package com.passwordmanager.repository;

import com.passwordmanager.model.PasswordEntry;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class VaultRepository {

    private static final String STORAGE_DIR = "storage";

    private static File getVaultFile(String username) {
        File dir = new File(STORAGE_DIR);
        if (!dir.exists()) dir.mkdir();
        return new File(dir, "vault_" + username + ".dat");
    }

    public static List<PasswordEntry> load(String username) {
        File file = getVaultFile(username);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<PasswordEntry>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void save(String username, List<PasswordEntry> entries) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(getVaultFile(username)))) {
            out.writeObject(entries);
        } catch (Exception e) {
            throw new RuntimeException("Vault save failed");
        }
    }
}
