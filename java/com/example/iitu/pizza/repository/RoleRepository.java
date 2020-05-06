package com.example.iitu.pizza.repository;

import com.example.iitu.pizza.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {

}
