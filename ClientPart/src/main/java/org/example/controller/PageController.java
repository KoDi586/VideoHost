package org.example.controller;


import org.example.dto.LineVideoResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class PageController {

    @GetMapping("/page")
    public String getPage(Model model) {
        return "page";
    }

    @GetMapping("/test")
    public String test(Model model) {
        List<LineVideoResponseDTO> videoList = Arrays.asList(
                new LineVideoResponseDTO(3, "titttttle", "dessssss"),
                new LineVideoResponseDTO(4,"jdflsd", "kdjfsldj"));
        model.addAttribute("list", videoList);
        return "testHTML";
    }
}
