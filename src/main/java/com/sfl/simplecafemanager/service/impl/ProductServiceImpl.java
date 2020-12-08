package com.sfl.simplecafemanager.service.impl;

import com.sfl.simplecafemanager.domain.entity.product.Product;
import com.sfl.simplecafemanager.domain.repository.ProductRepository;
import com.sfl.simplecafemanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements com.sfl.simplecafemanager.service.ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found for this id " + id));
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
