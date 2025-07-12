package com.shopping.shopping_cart.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Item {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private Double price;

   
}
