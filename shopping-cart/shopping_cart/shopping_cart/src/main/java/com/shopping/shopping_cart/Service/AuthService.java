package com.shopping.shopping_cart.Service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.shopping_cart.Model.User;
import com.shopping.shopping_cart.Repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public Optional<String> login(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsernameAndPassword(username, password);
        if (userOpt.isPresent()) {
            String token = UUID.randomUUID().toString();
            User user = userOpt.get();
            user.setToken(token);
            userRepository.save(user);
            return Optional.of(token);
        }
        return Optional.empty();
    }

    public Optional<User> getUserByToken(String token) {
        return userRepository.findByToken(token);
    }
}
