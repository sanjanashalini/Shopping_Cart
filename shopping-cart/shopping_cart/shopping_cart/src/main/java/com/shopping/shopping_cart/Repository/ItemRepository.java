package com.shopping.shopping_cart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.shopping_cart.Model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {}