package org.example.emusicstore.emusicstoreapi.service;

import org.example.emusicstore.emusicstoreapi.model.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(long customerId);

    Customer getCustomerByUsername(String username);

    List<Customer> getAllCustomers();
}
