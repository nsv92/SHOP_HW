package ru.gb.spring_shop_l2_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.gb.spring_shop_l2_1.dto.UserDto;
import ru.gb.spring_shop_l2_1.entity.User;
import ru.gb.spring_shop_l2_1.repository.UserRepository;
import ru.gb.spring_shop_l2_1.service.UserService;
import ru.gb.spring_shop_l2_1.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.beans.BeanProperty;

@Controller
public class UserController {

    private UserServiceImpl service;

    private ModelAndView mav;

    @Autowired
    public void setService(UserServiceImpl service) {
        this.service = service;
    }


    //    @GetMapping("/registration")
//    public String showRegistration(Model model, WebRequest request) {
//        UserDto userDto = new UserDto();
//        model.addAttribute("user", userDto);
//        return "registration";
//    }

    @GetMapping("/registration")
    public ModelAndView showRegPage() {
        ModelAndView modelAndView = new ModelAndView("registration");
        UserDto userDto = new UserDto();
        modelAndView.addObject("user", userDto);
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registerNewUser(@ModelAttribute("user") @Valid UserDto userDto,
                                        HttpServletRequest request, Errors errors) {
        try {
            User registered = service.registerNewUser(userDto);
        } catch (Exception e) {
//              ПОПРАВИТЬ СРАНИЦУ
//            mav.addObject("message", "Username is already exists!");
//            return mav;
            return new ModelAndView("redirect:http://localhost:8081/registration");
        }
        return new ModelAndView("redirect:http://localhost:8081/login");
//        return new ModelAndView("redirect:http://localhost:8081/products");
//        return mav;
    }
}
