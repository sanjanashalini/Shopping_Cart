package com.shopping.shopping_cart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shopping_cart.Model.User;
import com.shopping.shopping_cart.Repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
     private UserRepository repo;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return repo.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return repo.findByUsernameAndPassword(request.getUsername(), request.getPassword())
                .map(user -> {
                    String token = UUID.randomUUID().toString();
                    user.setToken(token);
                    repo.save(user);
                    return ResponseEntity.ok(Collections.singletonMap("token", token));
                }).orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }

    @GetMapping
    public List<User> allUsers() {
        return repo.findAll();
    }
}

