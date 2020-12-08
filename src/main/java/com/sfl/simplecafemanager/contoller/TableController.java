package com.sfl.simplecafemanager.contoller;

import com.sfl.simplecafemanager.domain.entity.table.Table;
import com.sfl.simplecafemanager.domain.entity.table.TableType;
import com.sfl.simplecafemanager.domain.entity.user.User;
import com.sfl.simplecafemanager.service.TableService;
import com.sfl.simplecafemanager.service.UserService;
import com.sfl.simplecafemanager.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/table")
public class TableController {

    @Autowired
    private TableService tableService;

    @Autowired
    private UserService userService;

    @Autowired
    private Validator validator;


    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public ModelAndView createTable(@ModelAttribute("table") @Valid Table table, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("/manager/addTable");
        }
        if (validator.isTableTypeExist(table.getTableType()))
            return new ModelAndView("forward:/admin/showTable", "message", "table with this number already exist");
        table.setTableStatus(TableType.CLOSE_AIR);
        tableService.saveTable(table);
        return new ModelAndView("forward:/admin/showTable", "message", "table created  successfully");
    }

    @RequestMapping(value = "/assignTo")
    public ModelAndView assignTableToWaiter(@RequestParam("waiterId") int waiterId, @RequestParam("tableId") int tableId) {
        User user = userService.getUserById(waiterId);
        if (user != null) {
            Table table = tableService.getTableById(tableId);
            if (table != null) {
                table.setWaiter(user);
                table.setTableStatus(TableType.OPEN_AIR);
                tableService.updateTable(table);
                return new ModelAndView("forward:/admin/showAssignTo", "message", "table assigned to waiter successfully");
            }
        }
        return new ModelAndView("forward:/admin/showAssignTo", "message", "table assigned to waiter failed");
    }

    @RequestMapping(value = "/showOrders/{tableId}")
    public ModelAndView showTableOrders(@PathVariable("tableId") int tableId) {
        Table table = tableService.getTableById(tableId);
        if (table != null) {
            return new ModelAndView("/waiter/tableOrders", "table", table);
        }
        return new ModelAndView("forward:/water/showPage", "message", "there are no table with this id");
    }
}
