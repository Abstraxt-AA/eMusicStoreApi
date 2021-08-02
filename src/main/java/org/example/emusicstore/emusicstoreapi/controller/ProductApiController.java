package org.example.emusicstore.emusicstoreapi.controller;

import org.example.emusicstore.emusicstoreapi.model.Product;
import org.example.emusicstore.emusicstoreapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Product API endpoint controller that is responsible for all /product/** requests.
 * Depends on ProductService in order to persist changes, and implements a check
 * for editing an already existing product (implemented in this fashion to maintain
 * compatibility with legacy code written for eMusicStore project).
 */

@RestController
@RequestMapping("/product")
class ProductApiController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get/all")
    List<Product> getAllProducts() {
        return productService.getProductList();
    }

    @GetMapping("/get/{productId}")
    Product getProduct(@PathVariable long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    String addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "Product added successfully.";
    }

    @DeleteMapping("/delete/{productId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    String deleteProduct(@PathVariable long productId) {
        productService.deleteProduct(productService.getProductById(productId));
        return "Product deleted successfully.";
    }

    @PatchMapping("/edit/{productId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    String editProduct(@PathVariable long productId, @RequestBody Product product) {
        Product editedProduct = productService.getProductById(productId);
        // If statements to check which fields to update
        // TODO: Use reflection with a for each loop
        if (product.getProductName() != null) {
            editedProduct.setProductName(product.getProductName());
        }
        if (product.getProductCategory() != null) {
            editedProduct.setProductCategory(product.getProductCategory());
        }
        if (product.getProductDescription() != null) {
            editedProduct.setProductDescription(product.getProductDescription());
        }
        if (product.getProductPrice() < 0) {
            editedProduct.setProductPrice(0);
        } else if (product.getProductPrice() > 0) {
            editedProduct.setProductPrice(product.getProductPrice());
        }
        if (product.getProductCondition() != null) {
            editedProduct.setProductCondition(product.getProductCondition());
        }
        if (product.getProductStatus() != null) {
            editedProduct.setProductStatus(product.getProductStatus());
        }
        if (product.getUnitsInStock() < 0) {
            editedProduct.setUnitsInStock(0);
        } else if (product.getUnitsInStock() > 0) {
            editedProduct.setUnitsInStock(product.getUnitsInStock());
        }
        if (product.getProductManufacturer() != null) {
            editedProduct.setProductManufacturer(product.getProductManufacturer());
        }

        productService.editProduct(editedProduct);
        return "Product edited successfully.";
    }
}
