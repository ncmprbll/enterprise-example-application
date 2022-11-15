package org.example.controller;

import org.example.model.CoffeeMachine;
import org.example.service.CoffeeMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        int result = service.insert(coffeeMachine);

        model.addAttribute("message", "Coffee machine added successfully");

        if (result == 0) {
            model.addAttribute("message", "An error has occurred while adding coffee machine");
        }

        return getAdd(model);
    }

    @GetMapping("/edit")
    public String getEdit(Model model) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        model.addAttribute("coffee_machine", coffeeMachine);
        return "edit";
    }

    @PostMapping("/edit")
    public String postEdit(@ModelAttribute CoffeeMachine coffeeMachine, Model model) {
        int result = service.update(coffeeMachine);

        model.addAttribute("message", "Coffee machine updated successfully");

        if (result == 0) {
            model.addAttribute("message", "No coffee machines were updated");
        }

        return getEdit(model);
    }

    @GetMapping("/delete")
    public String getDelete() {
        return "delete";
    }

    @PostMapping("/delete")
    public String postDelete(@RequestParam int id, Model model) {
        int result = service.delete(id);

        model.addAttribute("message", "Coffee machine deleted successfully");

        if (result == 0) {
            model.addAttribute("message", "No coffee machines were deleted");
        }

        return "delete";
    }

    @GetMapping("/list")
    public String getList(@RequestParam(required = false) String country, Model model) {
        model.addAttribute("coffee_machines", country == null ? service.findAll() : service.findByCountry(country));
        return "list";
    }
}
