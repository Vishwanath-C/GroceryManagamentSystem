package com.example.GroceryManagamentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GroceryManagamentSystem.exception.ResourceNotFoundException;
import com.example.GroceryManagamentSystem.model.GroceryItem;
import com.example.GroceryManagamentSystem.repository.GroceryItemRepository;

@Service
public class GroceryItemService {
    
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public GroceryItem createGroceryItem(GroceryItem groceryItem)
    {
        return groceryItemRepository.save(groceryItem);
    }

    public List<GroceryItem> getAllGroceryItems()
    {
        return groceryItemRepository.findAll();
    }

    public GroceryItem getGroceryItemById(Long id)
    {
        return groceryItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grocery Item not found with id : " + id));
    }

    public GroceryItem updateGroceryItem(Long id, GroceryItem groceryItemDetails)
    {
        GroceryItem groceryItem = getGroceryItemById(id);

        groceryItem.setName(groceryItemDetails.getName());
        groceryItem.setCategory(groceryItemDetails.getCategory());
        groceryItem.setQuantity(groceryItemDetails.getQuantity());
        groceryItem.setPrice(groceryItemDetails.getPrice());

        return groceryItemRepository.save(groceryItem);
    }

    public void deleteGroceryItem(Long id)
    {
        groceryItemRepository.delete(getGroceryItemById(id));
    }
}
