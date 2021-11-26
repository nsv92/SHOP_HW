package ru.gb.spring_shop_l2_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.gb.spring_shop_l2_1.dto.UserDto;

@Controller
public class MainController {

//    @GetMapping("/login")
//    public String showMyLoginPage() {
//        return "login";
//    }

//    @GetMapping("/login")
//    public String showMyLoginPage() {
//        return "modern-login";
//    }

    @GetMapping("/login")
    public ModelAndView showMyLoginPage() {
        return new ModelAndView("modern-login");
    }

    @GetMapping("/hello")
    public String showHelloWorldPage() {
        return "hello_world";
    }
}
