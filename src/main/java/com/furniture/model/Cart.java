package com.furniture.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
    private int cartTotal;

    @JsonIgnore
    @OneToOne(mappedBy = "cart")
    private User user;


    @ManyToMany
    private Set<Product> products;

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public  void clearProducts(){
        this.products.clear();
    }

    public void addProducts(Product product) {
        cartTotal=cartTotal+product.getPrize();
        products.add(product);
    }

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartTotal, User user, Set<Product> products) {
		super();
		this.cartTotal = cartTotal;
		this.user = user;
		this.products = products;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(int cartTotal) {
		this.cartTotal = cartTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}