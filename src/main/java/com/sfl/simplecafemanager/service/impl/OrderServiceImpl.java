package com.sfl.simplecafemanager.service.impl;

import com.sfl.simplecafemanager.domain.entity.order.Order;
import com.sfl.simplecafemanager.domain.repository.OrderRepository;
import com.sfl.simplecafemanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements com.sfl.simplecafemanager.service.OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(long id){
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found for this id " + id));
    }

    @Override
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Order order){
        long id = order.getId();
        Optional<Order> optionalProduct = orderRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return orderRepository.save(order);
        }
        throw new ResourceNotFoundException("Resource not found for this id " + id);
    }
}
