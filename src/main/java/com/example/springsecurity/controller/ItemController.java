package com.example.springsecurity.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.model.Item;

@RestController
public class ItemController {

    @Autowired
    ItemController itemService;

    public static List<Item> items;
    static{
        items = new ArrayList<>(Arrays.asList(new Item(1,"Spring Boot in Action","Books"),
                new Item(2,"Java 8 in Action","Books"),
                new Item(3,"Data Structures","Books"),
                new Item(4,"Spring Boot Security","Books")));
    }

    /**
     * Get all items.
     *  
	 * @author Mindbowser | deepak.kumbhar@mindbowser.com
     * @return
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/getAllItems")
    @ResponseBody
    public ResponseEntity<List<Item>> getAllItems() {
        //Reading all items (ADMIN only can access this)
        return new ResponseEntity<>(this.items, HttpStatus.OK);
    }

    /**
     * Get hello message.
     *  
	 * @author Mindbowser | deepak.kumbhar@mindbowser.com
     */
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello User!";
    }

}
