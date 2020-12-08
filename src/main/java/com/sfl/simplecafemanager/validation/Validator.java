package com.sfl.simplecafemanager.validation;

import com.sfl.simplecafemanager.domain.entity.table.Table;
import com.sfl.simplecafemanager.domain.entity.table.TableType;
import com.sfl.simplecafemanager.domain.entity.user.User;
import com.sfl.simplecafemanager.service.TableService;
import com.sfl.simplecafemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Validator {
    @Autowired
    private UserService userService;

    @Autowired
    private TableService tableService;

    public boolean isUsernameExist(String userName) {
        List<User> all = userService.getAllUsers();
        for (User user : all) {
            if (user.getUsername().equals(userName)) return true;
        }
        return false;
    }

    public boolean isTableTypeExist(TableType tableType) {
        List<Table> tables = tableService.getAllTables();
        for (Table table : tables) {
            if (table.getTableType() == tableType) return true;
        }
        return false;
    }
}
