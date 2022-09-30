package com.furniture.service;

import com.furniture.Repository.*;
import com.furniture.exception.ProductNotFoundException;
import com.furniture.model.Cart;
import com.furniture.model.Orders;
import com.furniture.model.Product;
import com.furniture.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;

    public void updateProduct(Product product, int id){
        Product optionalProduct= getProductById(id);
        Product myProduct=optionalProduct;
        if(myProduct!=null) {
            myProduct.setProductName(product.getProductName());
            myProduct.setPrize(product.getPrize());
        }
        productRepository.save(myProduct);
    }

    public void deleteProduct(int id)
    {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            Product delProduct=productRepository.findById(id).get();

            productRepository.deleteById(id);

        }
        else {
            throw new ProductNotFoundException("Product with productId "+id+"\n is not found");
        }
    }
    public ArrayList<Product> getAllProducts(){
        return new ArrayList<>(productRepository.findAll());
    }
    public Product getProductById(int id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return productRepository.findById(id).get();
        }
        else {
            throw new ProductNotFoundException("Product with productId "+id+" is not found");
        }
    }

    public void addOrderProduct(Long userId, Set<Product> products) {

        Optional<User> user= userRepository.findById(userId);
        if(user.isPresent()){

            User myUser=userRepository.findById(userId).get();
            Orders orders=new Orders();
            orders.setUsers(myUser);
            orders.setProducts(products);
            orderRepository.save(orders);

            myUser.addOrders(orders);
            userRepository.save(myUser);

            Cart cart=  myUser.getCart();
            cart.clearProducts();
            cart.setCartTotal(0);
            userRepository.save(myUser);


        }
        else {
            throw new ProductNotFoundException("User with UserId "+userId+" is not found");
        }
    }
    public void createProduct(Product product){

        productRepository.save(product);
    }
}