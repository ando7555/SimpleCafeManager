package com.sfl.simplecafemanager.contoller;

import com.sfl.simplecafemanager.domain.entity.order.Order;
import com.sfl.simplecafemanager.domain.entity.order.OrderStatus;
import com.sfl.simplecafemanager.domain.entity.table.Table;
import com.sfl.simplecafemanager.service.OrderService;
import com.sfl.simplecafemanager.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private TableService tableService;

    @RequestMapping(value = "/crate/{tableId}")
    public ModelAndView createOrder(@PathVariable("tableId") int tableId) {
        Table table = tableService.getTableById(tableId);
        if (table != null) {
            Order order = new Order();
            order.setTable(table);
            order.setOrderStatus(OrderStatus.OPEN);
            orderService.saveOrder(order);
            return new ModelAndView("forward:/waiter/showPage", "message", "order successfully created");
        }
        return new ModelAndView("forward:/waiter/showPage", "message", "failed to create order");
    }

    @RequestMapping(value = "/cancel/{orderId}")
    public ModelAndView cancelOrder(@PathVariable("orderId") int orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            order.setOrderStatus(OrderStatus.CANCELLED);
            long tableId = order.getTable().getId();
            orderService.updateOrder(order);
            return new ModelAndView("forward:/table/showOrders/" + tableId, "message", "the order cancelled successfully");
        }
        return new ModelAndView("forward:/waiter/showPage", "message", "cancel order is failed");

    }


    @RequestMapping(value = "/close/{orderId}")
    public ModelAndView closeOrder(@PathVariable("orderId") int orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            order.setOrderStatus(OrderStatus.CLOSED);
            long tableId = order.getTable().getId();
            orderService.updateOrder(order);
            return new ModelAndView("forward:/table/showOrders/" + tableId, "message", "the order closed successfully");
        }
        return new ModelAndView("forward:/waiter/showPage", "message", "close order is failed");

    }

    @RequestMapping(value = "/show/{orderId}")
    public ModelAndView showOrderDetails(@PathVariable("orderId") int orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            return new ModelAndView("/waiter/orderDetails", "order", order);
        }
        return new ModelAndView("redirect:/waiter/showPage");
    }
}
