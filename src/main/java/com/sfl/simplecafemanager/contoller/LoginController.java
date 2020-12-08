package com.sfl.simplecafemanager.contoller;

import com.sfl.simplecafemanager.domain.entity.user.User;
import com.sfl.simplecafemanager.domain.entity.user.UserType;
import com.sfl.simplecafemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcomePage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpSession session) {

        User user = userService.findByFirstNameAndLastName(username, password);
        if (user != null) {
            session.setMaxInactiveInterval(3600);
            session.setAttribute("user", user);
            if (user.getUserType() == UserType.MANAGER) {
                return new ModelAndView("/manager/manager");
            } else {
                return new ModelAndView("redirect:/waiter/showPage");
            }
        }
        return new ModelAndView("/login","message", "there are no user with this email and password");
    }
}
