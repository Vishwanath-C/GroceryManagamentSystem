package com.example.GroceryManagamentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GroceryManagamentSystem.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

    
}