package com.example.GroceryManagamentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GroceryManagamentSystem.model.GroceryItem;
import com.example.GroceryManagamentSystem.service.GroceryItemService;

@RestController
@RequestMapping("/api/grocery-items")
public class GroceryItemController {
    
    @Autowired
    private GroceryItemService groceryItemService;

    @PostMapping
    public GroceryItem createGroceyItem(@RequestBody GroceryItem groceryItem) {
        return groceryItemService.createGroceryItem(groceryItem);
    }

    @GetMapping
    public List<GroceryItem> getMethodName() {
        return groceryItemService.getAllGroceryItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getGroceryItemById(@PathVariable Long id) {
        return ResponseEntity.ok(groceryItemService.getGroceryItemById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> putMethodName(@PathVariable Long id, @RequestBody GroceryItem groceryItem) {
        GroceryItem updatedGroceryItem = groceryItemService.updateGroceryItem(id, groceryItem);
        return ResponseEntity.ok(updatedGroceryItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable Long id) {
        groceryItemService.deleteGroceryItem(id);
        return ResponseEntity.ok().build();
    }

}
