package com.sfl.simplecafemanager.service.impl;

import com.sfl.simplecafemanager.domain.entity.order.ProductInOrder;
import com.sfl.simplecafemanager.domain.repository.ProductInOrderRepository;
import com.sfl.simplecafemanager.service.ProductInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {

    private final ProductInOrderRepository productInOrderRepository;

    @Autowired
    public ProductInOrderServiceImpl(ProductInOrderRepository productInOrderRepository) {
        this.productInOrderRepository = productInOrderRepository;
    }

    public ProductInOrder saveProductInOrder(ProductInOrder productInOrder){
        return productInOrderRepository.save(productInOrder);
    }
}
