package org.example.service;

import org.example.models.CoffeeMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeMachineService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<CoffeeMachine> findAll() {
        return jdbcTemplate.query("SELECT * FROM coffee_machines", new BeanPropertyRowMapper<>(CoffeeMachine.class));
    }

    public int insert(CoffeeMachine cm) {
        try {
            return jdbcTemplate.update("INSERT INTO coffee_machines (brand, model, country_of_origin, price)" +
                    " VALUES (?, ?, ?, ?)",
                    cm.getBrand(),
                    cm.getModel(),
                    cm.getCountryOfOrigin(),
                    cm.getPrice());
        } catch (DataAccessException e) {
            return 0;
        }
    }

    public int update(CoffeeMachine cm) {
        String brand = cm.getBrand();
        String model = cm.getModel();
        String country = cm.getCountryOfOrigin();

        try {
            return jdbcTemplate.update("UPDATE coffee_machines SET brand = COALESCE(?, brand), model = COALESCE(?, model), " +
                    "country_of_origin = COALESCE(?, country_of_origin), price = COALESCE(?, price) WHERE id = ?",
                    brand.equals("") ? null : brand,
                    model.equals("") ? null : model,
                    country.equals("") ? null : country,
                    cm.getPrice(),
                    cm.getId());
        } catch (DataAccessException e) {
            return 0;
        }
    }

    public int delete(int id) {
        try {
            return jdbcTemplate.update("DELETE FROM coffee_machines WHERE id = ?", id);
        } catch (DataAccessException e) {
            return 0;
        }
    }
}
