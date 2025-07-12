package com.shopping.shopping_cart.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shopping_cart.Model.Cart;
import com.shopping.shopping_cart.Model.Order;
import com.shopping.shopping_cart.Model.User;
import com.shopping.shopping_cart.Repository.CartRepository;
import com.shopping.shopping_cart.Repository.OrderRepository;


import jakarta.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired private CartRepository cartRepo;
    @Autowired private OrderRepository orderRepo;

    @PostMapping
    public ResponseEntity<?> placeOrder(HttpServletRequest req) {
        User user = (User) req.getAttribute("user");
        Cart cart = cartRepo.findByUser(user).orElseThrow();

      Order order = new Order(null, user, cart);
        order.setUser(user);
        order.setCart(cart);
        return ResponseEntity.ok(orderRepo.save(order));
    }

    @GetMapping
    public ResponseEntity<?> userOrders(HttpServletRequest req) {
        User user = (User) req.getAttribute("user");
        return ResponseEntity.ok(orderRepo.findByUser(user));
    }
}

