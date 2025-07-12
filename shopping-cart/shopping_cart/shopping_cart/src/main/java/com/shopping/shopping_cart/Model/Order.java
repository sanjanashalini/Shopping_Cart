package com.shopping.shopping_cart.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Order {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @OneToOne
    private Cart cart;

    
}


