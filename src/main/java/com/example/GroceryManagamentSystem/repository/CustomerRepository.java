package com.example.GroceryManagamentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GroceryManagamentSystem.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
