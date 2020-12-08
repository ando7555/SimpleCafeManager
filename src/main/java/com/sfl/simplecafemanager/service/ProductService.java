package com.sfl.simplecafemanager.service;

import com.sfl.simplecafemanager.domain.entity.product.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    Product getProductById(long id);

    List<Product> getAllProducts();
}
