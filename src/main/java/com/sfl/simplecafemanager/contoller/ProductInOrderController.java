package com.sfl.simplecafemanager.contoller;

import com.sfl.simplecafemanager.domain.entity.order.Order;
import com.sfl.simplecafemanager.domain.entity.order.OrderStatus;
import com.sfl.simplecafemanager.domain.entity.order.ProductInOrder;
import com.sfl.simplecafemanager.domain.entity.product.Product;
import com.sfl.simplecafemanager.service.OrderService;
import com.sfl.simplecafemanager.service.ProductInOrderService;
import com.sfl.simplecafemanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;


@Controller
@RequestMapping("/productInOrder")
public class ProductInOrderController {

    @Autowired
    private ProductInOrderService productInOrderService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/productInOrder")
    public ModelAndView showProductInOrderPage(@PathVariable("orderId") int orderId, @PathVariable("tableId") int tableId, Model model) {
        Order order = orderService.getOrderById(orderId);
        if (order != null && order.getOrderStatus() == OrderStatus.OPEN) {
            List<Product> products = productService.getAllProducts();
            model.addAttribute("products", products);
            model.addAttribute("order", order);
            return new ModelAndView("/waiter/addProductInOrder");
        }
        return new ModelAndView("forward:/table/showOrders/" + tableId, "message", "show product in order page failed");
    }

    @PostMapping("/add")
    public ModelAndView addProductInOrder(@RequestParam("productId") int productId, @RequestParam("orderId") int orderId,
                                          @RequestParam("amount") BigDecimal amount) {
        if (amount.intValue() < 1) return new ModelAndView("forward:/waiter/showPage", "message", "add product in order failed ");
        Order order = orderService.getOrderById(orderId);
        Product product = productService.getProductById(productId);
        if (product != null && order != null) {
            ProductInOrder productInOrder = new ProductInOrder();
            productInOrder.setProduct(product);
            productInOrder.setProductOrder(order);
            productInOrder.setAmount(amount);
            productInOrderService.saveProductInOrder(productInOrder);
            long tableId = order.getTable().getId();
            return new ModelAndView("forward:/productInOrder/showPage/" + tableId + "/" + orderId);
        }
        return new ModelAndView("forward:/waiter/showPage", "message", "add product in order failed ");
    }
}
