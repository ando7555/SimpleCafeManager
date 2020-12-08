package com.sfl.simplecafemanager.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/waiter")
public class WaiterController {

    @RequestMapping(value = "/showPage")
    public ModelAndView showWaiterPage(){
        return new ModelAndView("/waiter/waiter");
    }
}
