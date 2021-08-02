package org.example.emusicstore.emusicstoreapi.service;

import org.example.emusicstore.emusicstoreapi.model.Cart;
import org.example.emusicstore.emusicstoreapi.model.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(long productId);
}
