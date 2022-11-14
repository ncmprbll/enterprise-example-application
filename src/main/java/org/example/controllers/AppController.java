package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/add")
    public String getAdd() {
        return "add";
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
