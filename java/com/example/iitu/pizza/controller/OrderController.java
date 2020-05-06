package com.example.iitu.pizza.controller;

import com.example.iitu.pizza.entity.Order;
import com.example.iitu.pizza.entity.Pizza;
import com.example.iitu.pizza.exception.OrderNotFoundException;
import com.example.iitu.pizza.repository.OrderRepository;
import com.example.iitu.pizza.repository.PizzaRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Api(value = "Order Controller class", description = "This class allows to interact with Order object")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("")
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @PostMapping("/create")
    public Order addOrder(@RequestBody Order order){
        return orderRepository.saveAndFlush(order);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) throws OrderNotFoundException
    {
        Order order =  orderRepository.findById(id).get();
        if(order==null)
            throw new OrderNotFoundException();
        return order;
    }

    @GetMapping("/{username}")
    public List<Order> getAllUsersOrders(@PathVariable String username){
        return orderRepository.findAllByUsers_Username(username);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderRepository.deleteById(id);
    }

}
