package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginIn(Model model) {
        return "login";
    }

    @GetMapping("/singUp")
    public String getRegistration(Model model) {
        return "regist";
    }
}
