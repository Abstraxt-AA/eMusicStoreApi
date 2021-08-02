package org.example.emusicstore.emusicstoreapi.service;

import org.example.emusicstore.emusicstoreapi.model.CustomerOrder;

public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(long cartId);
}
