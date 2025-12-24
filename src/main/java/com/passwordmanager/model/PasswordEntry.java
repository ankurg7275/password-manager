package com.passwordmanager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class PasswordEntry implements Serializable {

    private String site;
    private String username;
    private String encryptedPassword;
    private LocalDate expiry;

    public PasswordEntry(String site, String username, String encryptedPassword, LocalDate expiry) {
        this.site = site;
        this.username = username;
        this.encryptedPassword = encryptedPassword;
        this.expiry = expiry;
    }

    public String getSite() { return site; }
    public String getUsername() { return username; }
    public String getEncryptedPassword() { return encryptedPassword; }
    public LocalDate getExpiry() { return expiry; }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }
}
