package com.example.iitu.pizza.repository;

import com.example.iitu.pizza.entity.User;
import com.example.iitu.pizza.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    List<User> findAllByUserRoleContains(String role);

}
