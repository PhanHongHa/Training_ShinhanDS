package com.example.demoJDBC;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemRepository itemRepo;

    @GetMapping("/getAllItems")
    public List<Item> getAllItems(){
        return itemRepo.getAllItems();
    }

}