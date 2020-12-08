package com.sfl.simplecafemanager.contoller;

import com.sfl.simplecafemanager.domain.entity.product.Product;
import com.sfl.simplecafemanager.domain.entity.table.Table;
import com.sfl.simplecafemanager.domain.entity.user.User;
import com.sfl.simplecafemanager.service.TableService;
import com.sfl.simplecafemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class ManagerController {

    @Autowired
    private UserService userService;

    @Autowired
    private TableService tableService;


    @RequestMapping(value = "/showUser")
    public ModelAndView showAddUserPage() {
        return new ModelAndView("/manager/addWaiter", "user", new User());
    }


    @RequestMapping(value = "/showTable")
    public ModelAndView showAddTablePage() {
        return new ModelAndView("/manager/addTable", "table", new Table());
    }


    @RequestMapping(value = "/showAssignTo")
    public ModelAndView showAddProductPage() {
        return new ModelAndView("/manager/addProduct", "product", new Product());
    }

    @GetMapping(value = "/showAssignTo")
    public ModelAndView assignTableToWaiter(Model model) {
        List<User> users = userService.getAllUsers();
        List<Table> tables = tableService.getAllTables();
        model.addAttribute("users", users);
        model.addAttribute("tables", tables);
        return new ModelAndView("/manager/assignToWaiter");
    }
}
