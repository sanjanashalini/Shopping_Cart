package com.shopping.shopping_cart.Model;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Cart {
    @Id @GeneratedValue
    private Long id;

    @OneToOne
    private User user;

    @ManyToMany
    private List<Item> items = new ArrayList<>();

    
}

