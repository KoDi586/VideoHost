package org.example.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/singUp")
    public String getRegistration(Model model) {
        return "regist";
    }

}
