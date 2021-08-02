package org.example.emusicstore.emusicstoreapi.dao;

import org.example.emusicstore.emusicstoreapi.model.Customer;

import java.util.List;

public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomerById(long customerId);

    Customer getCustomerByUsername(String username);

    List<Customer> getAllCustomers();
}
