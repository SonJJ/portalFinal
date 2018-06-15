package com.example.examtest.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    @GetMapping("/test1")
    public String start(){
        return "list";

    }
    @GetMapping("/test2")
    public String setForm(String name, Integer password, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("password", password);
        return "addList";
    }

}