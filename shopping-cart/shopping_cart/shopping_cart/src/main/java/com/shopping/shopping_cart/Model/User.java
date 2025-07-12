package com.shopping.shopping_cart.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class User {
    @Id 
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private String token;

 
}


