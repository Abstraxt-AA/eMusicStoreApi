package org.example.emusicstore.emusicstoreapi.dao.impl;

import org.example.emusicstore.emusicstoreapi.dao.CartItemDao;
import org.example.emusicstore.emusicstoreapi.model.Cart;
import org.example.emusicstore.emusicstoreapi.model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {
    // TODO: Use Spring Data

    @Autowired
    private Session session;

    @Override
    public void addCartItem(CartItem cartItem) {
//        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
//        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    @Override
    public void removeAllCartItems(Cart cart) {

        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem cartItem : cartItems) {
            removeCartItem(cartItem);
        }
    }

    @Override
    public CartItem getCartItemByProductId(long productId) {
//        Session session = sessionFactory.getCurrentSession();

        // Custom query to select a cart item that's bound to a specific product

        Query query = session.createQuery("from CartItem where product.productId = ?");
        query.setLong(0, productId);

        CartItem cartItem = (CartItem) query.uniqueResult();
        session.flush();
        return cartItem;
    }
}
