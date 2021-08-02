package org.example.emusicstore.emusicstoreapi.service;


import org.example.emusicstore.emusicstoreapi.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    Product getProductById(long id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
