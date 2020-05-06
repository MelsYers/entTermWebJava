package com.example.iitu.pizza.controller;


import com.example.iitu.pizza.entity.Pizza;
import com.example.iitu.pizza.exception.PizzaNotFoundException;
import com.example.iitu.pizza.repository.PizzaRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
@Api(value = "Pizza Controller class", description = "This class allows to interact with Pizza object")
public class PizzaController {


    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("")
    public List<Pizza> getAllPizzas(){
        return pizzaRepository.findAll();
    }

    @PostMapping("/create")
    public Pizza addPizza(@RequestBody Pizza pizza){
        return pizzaRepository.saveAndFlush(pizza);
    }

    @GetMapping("/{id}")
    public Pizza getPizzaById(@PathVariable Long id) throws PizzaNotFoundException {
        Pizza pizza = pizzaRepository.findById(id).get();
        if (pizza == null)
            throw new PizzaNotFoundException();
        return pizza;
    }

    @PutMapping("/{id}")
    public void updatePizza(@PathVariable Long id, @RequestBody Pizza pizza){
        Pizza pizza1 = pizzaRepository.findById(id).orElse(null);

        if (pizza1 != null) {
            pizza1.setTitle(pizza.getTitle());
            pizza1.setPrice(pizza.getPrice());
            pizza1.setDiameter(pizza.getDiameter());

            pizzaRepository.saveAndFlush(pizza1);
        }

    }

    @DeleteMapping("/{id}")
    public void deletePizza(@PathVariable Long id){
        pizzaRepository.deleteById(id);
    }


}
