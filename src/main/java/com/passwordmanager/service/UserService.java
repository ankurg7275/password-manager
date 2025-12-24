package com.passwordmanager.service;

import com.passwordmanager.model.User;
import com.passwordmanager.repository.UserRepository;
import com.passwordmanager.security.PasswordHasher;

public class UserService {

    public boolean register(String username, String password) {
        if (UserRepository.exists(username)) {
            return false;
        }

        String hash = PasswordHasher.hash(password);
        User user = new User(username, hash);
        UserRepository.save(user);
        return true;
    }

    public boolean login(String username, String password) {
        User user = UserRepository.find(username);
        if (user == null) {
            return false;
        }

        String hash = PasswordHasher.hash(password);
        return hash.equals(user.getPasswordHash());
    }
}
