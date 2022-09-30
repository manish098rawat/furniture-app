package com.furniture.service;

import com.furniture.Repository.OrderRepository;
import com.furniture.Repository.ProductRepository;
import com.furniture.Repository.UserRepository;
import com.furniture.model.Orders;
import com.furniture.model.Product;
import com.furniture.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    public void addOrder(Orders orders){
        orderRepository.save(orders);
    }
    public List<Orders> getAllOrders(){
        return orderRepository.findAll();
    }
    public  void deleteOrder(int orderId, long userId){

        User user = userRepository.findById(userId).get();
        Orders orders = orderRepository.findById(orderId).get();
        user.removeOrders(orders);
        userRepository.save(user);
        orderRepository.deleteById(orderId);



    }

    public void placeOrder(int orderId, int productId) {
        Orders orders= orderRepository.findById(orderId).get();
        Product product= productRepository.findById(productId).get();
        orders.putProduct(product);
        orderRepository.save(orders);
    }

    public void addUser(int orderId, long userId) {
        Orders orders= orderRepository.findById(orderId).get();
        User users= userRepository.findById(userId).get();
        orders.setUsers(users);
        orderRepository.save(orders);
    }

    public List<Orders> getOrderByUserId(long id) {
        User user = userRepository.findById(id).get();
        List <Orders> orders = user.getOrders();


        return orders;
    }
}