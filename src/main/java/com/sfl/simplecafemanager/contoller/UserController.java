package com.sfl.simplecafemanager.contoller;

import com.sfl.simplecafemanager.domain.entity.user.User;
import com.sfl.simplecafemanager.domain.entity.user.UserType;
import com.sfl.simplecafemanager.service.UserService;
import com.sfl.simplecafemanager.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Validator validator;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("/manager/addWaiter");
        }
        if (validator.isUsernameExist(user.getUsername()))
            return new ModelAndView("forward:/admin/showUser", "message", "waiter with this name is already exist");
        user.setUserType(UserType.WAITER);
        userService.saveUser(user);
        return new ModelAndView("forward:/admin/showUser", "message", "waiter created  successfully");
    }
}
