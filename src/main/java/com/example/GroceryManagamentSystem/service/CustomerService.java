package com.example.GroceryManagamentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GroceryManagamentSystem.exception.ResourceNotFoundException;
import com.example.GroceryManagamentSystem.model.Customer;
import com.example.GroceryManagamentSystem.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer)
    {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id)
    {
        return customerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id : " + id));
    }

    public Customer updateCustomer(Long id, Customer customerDetails)
    {
        Customer customer = getCustomerById(id);

        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setAddress(customerDetails.getAddress());
        customer.setPhone(customerDetails.getPhone());

        return customerRepository.save(customer);      
    }

    public void deleteCustomerById(Long id)
    {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
