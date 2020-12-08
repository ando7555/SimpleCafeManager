package com.sfl.simplecafemanager.contoller;

import com.sfl.simplecafemanager.domain.entity.product.Product;
import com.sfl.simplecafemanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("product")  Product product, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("/manager/addProduct");
        }
        productService.saveProduct(product);
        return new ModelAndView("forward:/admin/showUser", "message", "product created  successfully");
    }
}
