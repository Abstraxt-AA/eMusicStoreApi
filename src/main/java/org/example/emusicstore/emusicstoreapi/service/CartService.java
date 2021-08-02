package org.example.emusicstore.emusicstoreapi.service;

import org.example.emusicstore.emusicstoreapi.model.Cart;

public interface CartService {

    Cart getCartById(long cartId);

    void updateCart(Cart cart);
}
