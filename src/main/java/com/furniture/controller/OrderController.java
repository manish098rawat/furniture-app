package com.furniture.controller;

import com.furniture.model.Orders;
import com.furniture.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*", maxAge = 3006)
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/all")
    public List<Orders> getAllOrders() {

        return orderService.getAllOrders();

    }
    @GetMapping("/{id}")
    public List<Orders> getOrderByUserId(@PathVariable long id){
        return orderService.getOrderByUserId(id);
    }
    @PostMapping("/create")
    public void addOrders(@RequestBody Orders order){
        orderService.addOrder(order);
    }
    @DeleteMapping("/{orderId}/user/{userId}")
    public void deleteOrder(@PathVariable int orderId, @PathVariable long userId){
        orderService.deleteOrder(orderId, userId);
    }

    @PutMapping("/{orderId}/product/{productId}")
    public void addProduct(@PathVariable int orderId, @PathVariable int productId){
        orderService.placeOrder(orderId,productId);

    }
    @PutMapping("/{orderId}/user/{userId}")
    public void addUser(@PathVariable int orderId, @PathVariable int userId){
        orderService.addUser(orderId,userId);

    }



}