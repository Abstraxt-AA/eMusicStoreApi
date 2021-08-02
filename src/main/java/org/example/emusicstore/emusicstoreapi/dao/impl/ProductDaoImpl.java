package org.example.emusicstore.emusicstoreapi.dao.impl;

import org.example.emusicstore.emusicstoreapi.dao.ProductDao;
import org.example.emusicstore.emusicstoreapi.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
    // TODO: Use Spring Data

    @Autowired
    private Session session;

    @Override
    public void addProduct(Product product) {

//        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public Product getProductById(long id) {

//        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        session.flush();
        return product;
    }

    @Override
    public List<Product> getProductList() {

//        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        @SuppressWarnings("unchecked")
        List<Product> productList = query.list();
        session.flush();

        return productList;
    }

    @Override
    public void deleteProduct(Product product) {

//        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }

    @Override
    public void editProduct(Product product) {

//        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }
}
