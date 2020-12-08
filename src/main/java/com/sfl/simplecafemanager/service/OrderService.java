package com.sfl.simplecafemanager.service;

import com.sfl.simplecafemanager.domain.entity.order.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);

    Order getOrderById(long id);

    List<Order> getAllOrders();

    Order updateOrder(Order order);
}
