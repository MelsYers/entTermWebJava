package com.example.iitu.pizza.controller;

import com.example.iitu.pizza.entity.Pizza;
import com.example.iitu.pizza.entity.User;
import com.example.iitu.pizza.entity.UserRole;
import com.example.iitu.pizza.exception.NoRoleException;
import com.example.iitu.pizza.exception.UserNotFoundException;
import com.example.iitu.pizza.repository.PizzaRepository;
import com.example.iitu.pizza.repository.RoleRepository;
import com.example.iitu.pizza.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(value = "Role Controller class", description = "This class allows to interact with role object")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("")
    public List<UserRole> getAllRoles(){
        return roleRepository.findAll();
    }

    @PostMapping("/add")
    public UserRole addRole(@RequestBody UserRole userRole){
        return roleRepository.saveAndFlush(userRole);
    }

    @GetMapping("/{id}")
    public UserRole findRoleById(@PathVariable Long id) throws NoRoleException {
        UserRole userRole = roleRepository.findById(id).orElse(null);
        if (userRole == null){
            throw new NoRoleException();
        }
        return userRole;
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id){
        roleRepository.deleteById(id);
    }


}
