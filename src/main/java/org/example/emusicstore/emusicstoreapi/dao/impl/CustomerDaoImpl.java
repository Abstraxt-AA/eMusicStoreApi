package org.example.emusicstore.emusicstoreapi.dao.impl;

import org.example.emusicstore.emusicstoreapi.dao.CustomerDao;
import org.example.emusicstore.emusicstoreapi.model.Authorities;
import org.example.emusicstore.emusicstoreapi.model.Cart;
import org.example.emusicstore.emusicstoreapi.model.Customer;
import org.example.emusicstore.emusicstoreapi.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
    // TODO: Use Spring Data

    @Autowired
    private Session session;

    @Override
    public void addCustomer(Customer customer) {
        // TODO: Set up Hibernate Cascade for billing and shipping addresses

//        Session session = sessionFactory.getCurrentSession();

        // Set the customer field for billing address and shipping address

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        // Update all three entries in their respective tables

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        // Create a new user entry for the customer and update it accordingly

        Users newUser = new Users();
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());
        newUser.setUsername(customer.getCustomerUsername());
        newUser.setPassword(customer.getCustomerPassword());

        // Create a new authority entry for the customer

        Authorities newAuthority = new Authorities();
        newAuthority.setAuthority("ROLE_USER");
        newAuthority.setUsername(customer.getCustomerUsername());

        // Persist the user and authority entries

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        // Create a new cart entry and link it to the user

        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);

        // Persist the cart and the customer

        session.saveOrUpdate(cart);
        session.saveOrUpdate(customer);

        session.flush();
    }

    @Override
    public Customer getCustomerById(long customerId) {

//        Session session = sessionFactory.getCurrentSession();

        Customer customer = (Customer) session.get(Customer.class, customerId);
        session.flush();

        return customer;
    }

    @Override
    public Customer getCustomerByUsername(String username) {

//        Session session = sessionFactory.getCurrentSession();

        // Custom query to retrieve user by username

        Query query = session.createQuery("from Customer where customerUsername = ?");
        query.setString(0, username);

        return (Customer) query.uniqueResult();
    }

    @Override
    public List<Customer> getAllCustomers() {

//        Session session = sessionFactory.getCurrentSession();

        // Custom query to retrieve all users from table

        Query query = session.createQuery("from Customer");

        @SuppressWarnings("unchecked")
        List<Customer> customers = query.list();

        return customers;
    }
}
