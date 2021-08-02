package org.example.emusicstore.emusicstoreapi.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Customer Order Model
 * Customer Order ID - long, auto-generated
 * One-to-one relationship with carts
 * One-to-one relationship with customers
 * One-to-one relationship with customer billing and shipping addresses
 * A field to store the grand-total of the order as a double
 */

@Entity
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = -9082411238969569566L;

    @Id
    @GeneratedValue
    private long customerOrderId;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    private double grandTotal;

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public long getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(long customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
