package org.example.service;

import org.example.models.CoffeeMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeMachineService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<CoffeeMachine> findAll() {
        return  jdbcTemplate.query("SELECT * FROM coffee_machines", new BeanPropertyRowMapper<>(CoffeeMachine.class));
    }
}
