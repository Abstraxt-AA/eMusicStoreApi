package org.example.emusicstore.emusicstoreapi.dao.impl;

import org.example.emusicstore.emusicstoreapi.dao.CartDao;
import org.example.emusicstore.emusicstoreapi.model.Cart;
import org.example.emusicstore.emusicstoreapi.service.CustomerOrderService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {
    // TODO: Use Spring Data

    @Autowired
    private Session session;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Override
    public Cart getCartById(long cartId) {
//        Session session = sessionFactory.getCurrentSession();
        Cart cart = session.get(Cart.class, cartId);
        session.flush();
        return cart;
    }

    @Override
    public void updateCart(Cart cart) {
        long cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

//        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
        session.flush();
    }

    @Override
    public Cart validate(long cartId) throws IOException {
        // Checking if cart is valid for checkout
        Cart cart = getCartById(cartId);
        if (cart == null || cart.getCartItems().size() == 0) {
            throw new IOException(cartId+"");
        }
        updateCart(cart);
        return cart;
    }
}
