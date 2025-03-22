package com.example.GroceryManagamentSystem.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GroceryManagamentSystem.dto.OrderRequest;
import com.example.GroceryManagamentSystem.exception.ResourceNotFoundException;
import com.example.GroceryManagamentSystem.model.Customer;
import com.example.GroceryManagamentSystem.model.GroceryItem;
import com.example.GroceryManagamentSystem.model.Order;
import com.example.GroceryManagamentSystem.repository.CustomerRepository;
import com.example.GroceryManagamentSystem.repository.GroceryItemRepository;
import com.example.GroceryManagamentSystem.repository.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public Order createOrder(OrderRequest orderRequest)
    {
        Customer customer = customerRepository.findById(orderRequest.getCustomerId())
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id : " + orderRequest.getCustomerId()));

        List<GroceryItem> groceryItems = groceryItemRepository.findAllById(orderRequest.getGroceryItemIds());

        Order order = new Order();

        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());
        order.setGroceryItems(groceryItems);
        order.setPrice(groceryItems.stream().mapToDouble(x -> (x.getPrice() * x.getQuantity())).sum());

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders()
    {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id)
    {
        return orderRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Order not found with id : " + id));
    }

    public void deleteOrder(Long id)
    {
        orderRepository.delete(getOrderById(id));
    }
}
