package com.restaurant.DBService;

import com.restaurant.entity.MenuItem;
import com.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository repository;

    // View all menu items
    public List<MenuItem> getAllMenu() {
        return repository.findAll();
    }

    // Add menu item
    public MenuItem saveMenu(MenuItem item) {
        return repository.save(item);
    }

    // Delete menu item
    public void deleteMenu(Long id) {
        repository.deleteById(id);
    }

    // Find menu item by ID
    public MenuItem getMenuById(Long id) {
        return repository.findById(id).orElse(null);
    }
}