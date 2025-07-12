package com.shopping.shopping_cart.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shopping_cart.Model.Cart;
import com.shopping.shopping_cart.Model.Item;
import com.shopping.shopping_cart.Model.User;
import com.shopping.shopping_cart.Repository.CartRepository;
import com.shopping.shopping_cart.Repository.ItemRepository;


import jakarta.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired 
    private CartRepository cartRepo;
    @Autowired 
    private ItemRepository itemRepo;

    @PostMapping
    public ResponseEntity<?> addItemToCart(@RequestBody Map<String, Long> body, HttpServletRequest req) {
        User user = (User) req.getAttribute("user");
        Long itemId = body.get("item_id");
        Item item = itemRepo.findById(itemId).orElseThrow();

        Cart cart = cartRepo.findByUser(user).orElseGet(() -> {
            Cart c = new Cart(itemId, user, null);
            c.setUser(user);
            return c;
        });
        cart.getItems().add(item);
        return ResponseEntity.ok(cartRepo.save(cart));
    }

    @GetMapping
    public List<Cart> allCarts() {
        return cartRepo.findAll();
    }
}

