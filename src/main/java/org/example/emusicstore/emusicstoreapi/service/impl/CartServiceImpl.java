package org.example.emusicstore.emusicstoreapi.service.impl;

import org.example.emusicstore.emusicstoreapi.dao.CartDao;
import org.example.emusicstore.emusicstoreapi.model.Cart;
import org.example.emusicstore.emusicstoreapi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    @Lazy
    private CartDao cartDao;

    @Override
    public Cart getCartById(long cartId) {
        return cartDao.getCartById(cartId);
    }

    @Override
    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }
}
