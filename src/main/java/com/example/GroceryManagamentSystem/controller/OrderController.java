package com.example.GroceryManagamentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.GroceryManagamentSystem.dto.OrderRequest;
import com.example.GroceryManagamentSystem.model.Order;
import com.example.GroceryManagamentSystem.service.OrderService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order postMethodName(@RequestBody OrderRequest orderRequest) {        
        return orderService.createOrder(orderRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteOrder(@PathVariable Long id)
   {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
   }   
}
