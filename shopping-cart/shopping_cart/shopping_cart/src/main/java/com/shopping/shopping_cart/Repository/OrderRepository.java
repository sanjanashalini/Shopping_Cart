package com.shopping.shopping_cart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.shopping_cart.Model.Order;
import com.shopping.shopping_cart.Model.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
