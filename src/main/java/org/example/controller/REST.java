package org.example.controller;

import org.example.model.CoffeeMachine;
import org.example.service.CoffeeMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class REST {
    @Autowired
    CoffeeMachineService service;

    @RequestMapping(value="/coffee_machines", method= RequestMethod.GET)
    public ResponseEntity<List<CoffeeMachine>> getCoffeeMachines() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/coffee_machines", method= RequestMethod.POST)
    public ResponseEntity<Object> postCoffeeMachines(@RequestBody CoffeeMachine coffeeMachine) {
        if (service.insert(coffeeMachine) != 0) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value="/coffee_machines", method=RequestMethod.PUT)
    public ResponseEntity<Object> putCoffeeMachines(@RequestBody CoffeeMachine coffeeMachine) {
        if (service.update(coffeeMachine) != 0) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value="/coffee_machines/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCoffeeMachines(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
