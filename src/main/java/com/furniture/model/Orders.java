package com.furniture.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private int orderTotal;

    @ManyToMany
    @JoinTable(name ="ordered_products",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "product_productId"))
    private Set<Product> products;
    @JsonIgnore
    @ManyToOne
    private User users;
    
    @OneToOne
    private Payment payment;

    public Orders(int orderTotal, Set<Product> products, User users, Payment payment) {
		super();
		this.orderTotal = orderTotal;
		this.products = products;
		this.users = users;
		this.payment = payment;
	}

	public void setProducts(Set<Product> products) {
        this.products = products;

        for(Product e: products){
            setOrderTotal(getOrderTotal() + e.getPrize()) ;
        }

    }

    public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void putProduct(Product product) {
        orderTotal=orderTotal+product.getPrize();
        products.add(product);
    }

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int orderTotal, Set<Product> products, User users) {
		super();
		this.orderTotal = orderTotal;
		this.products = products;
		this.users = users;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}