package com.restaurant.controller;

import com.restaurant.DBService.MenuService;
import com.restaurant.entity.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MenuController {

    @Autowired
    private MenuService service;

    // Display menu list
    @GetMapping("/menu")
    public String viewMenu(Model model) {

        model.addAttribute("menuList",
                service.getAllMenu());

        return "menu-list";
    }

    // Show add menu form
    @GetMapping("/addMenu")
    public String addMenuPage(Model model) {

        model.addAttribute("menuItem",
                new MenuItem());

        return "add-menu";
    }

    // Save menu item
    @PostMapping("/save")
    public String saveMenu(@ModelAttribute MenuItem item) {

        service.saveMenu(item);

        return "redirect:/menu";
    }
}