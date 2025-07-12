package com.shopping.shopping_cart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.shopping_cart.Model.Cart;
import com.shopping.shopping_cart.Model.User;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}
