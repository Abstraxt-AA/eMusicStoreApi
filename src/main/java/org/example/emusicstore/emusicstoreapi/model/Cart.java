package org.example.emusicstore.emusicstoreapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Cart Model
 * Cart ID - long, auto-generated
 * A list of cart items that the cart contains, one-to-many relationship
 * One-to-one relationship with customer entries
 * A field defining the grand total of the cart
 */

@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = -8116563238278254074L;

    @Id
    @GeneratedValue
    private long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

    private double grandTotal;

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

}
