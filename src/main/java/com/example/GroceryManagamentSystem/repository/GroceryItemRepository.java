package com.example.GroceryManagamentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GroceryManagamentSystem.model.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long>{
    
}
