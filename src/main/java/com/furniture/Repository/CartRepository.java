package com.furniture.Repository;

import com.furniture.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CartRepository extends JpaRepository<Cart,Integer> {

}