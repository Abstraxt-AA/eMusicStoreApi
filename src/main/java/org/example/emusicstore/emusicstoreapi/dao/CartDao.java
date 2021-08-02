package org.example.emusicstore.emusicstoreapi.dao;

import org.example.emusicstore.emusicstoreapi.model.Cart;

import java.io.IOException;

public interface CartDao {

    Cart getCartById(long cartId);

    void updateCart(Cart cart);

    Cart validate(long cartId) throws IOException;
}
