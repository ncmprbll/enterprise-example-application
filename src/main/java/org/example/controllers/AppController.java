package org.example.controllers;

import org.example.models.CoffeeMachine;
import org.example.service.CoffeeMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AppController {
    @Autowired
    CoffeeMachineService service;

    @GetMapping("/add")
    public String getAdd(Model model) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        model.addAttribute("coffee_machine", coffeeMachine);
        return "add";
    }

    @PostMapping("/add")
    public String postAdd(@ModelAttribute CoffeeMachine coffeeMachine, Model model) {
        model.addAttribute("message", "Coffee machine added successfully");
        return getAdd(model);
    }

    @GetMapping("/edit")
    public String getEdit() {
        return "edit";
    }

    @GetMapping("/delete")
    public String getDelete() {
        return "delete";
    }
}
