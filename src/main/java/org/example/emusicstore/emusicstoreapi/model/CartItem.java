package org.example.emusicstore.emusicstoreapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Cart Item Model
 * Cart Item ID - long, auto-generated
 * Many-to-one relationship with cart entries
 * Many-to-one relationship with product entries
 * Quantity - integer
 * Total Price - double, defined as unit price * quantity
 */

@Entity
public class CartItem implements Serializable {


    private static final long serialVersionUID = -7827303488969216560L;
    @Id
    @GeneratedValue
    private long cartItemId;

    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;
    private double totalPrice;

    public CartItem() {

    }

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getProductPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
