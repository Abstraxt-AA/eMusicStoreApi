package org.example.emusicstore.emusicstoreapi.service.impl;

import org.example.emusicstore.emusicstoreapi.dao.CartItemDao;
import org.example.emusicstore.emusicstoreapi.model.Cart;
import org.example.emusicstore.emusicstoreapi.model.CartItem;
import org.example.emusicstore.emusicstoreapi.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);
    }

    @Override
    public CartItem getCartItemByProductId(long productId) {
        return cartItemDao.getCartItemByProductId(productId);
    }
}
