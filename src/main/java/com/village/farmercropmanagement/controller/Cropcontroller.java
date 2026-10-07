package com.village.farmercropmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.farmercropmanagement.model.Crop;
import com.village.farmercropmanagement.service.Cropservice;

@RestController
@RequestMapping("/crop")
public class Cropcontroller {

    @Autowired
    Cropservice cropService;

    // Welcome
    @GetMapping("/wel")
    public String welcome() {
        return "Welcome to Farmer Crop Management REST API";
    }

    // Create Crop
    @PostMapping
    public Crop createCrop(@RequestBody Crop c) {
        return cropService.createCrop(c);
    }

    // Get All Crops
    @GetMapping
    public List<Crop> getAllCrops() {
        return cropService.getAllCrops();
    }

    // Get Crop By ID
    @GetMapping("/{id}")
    public Crop getCropById(@PathVariable Long id) {
        return cropService.getCropById(id);
    }

    // Update Crop
    @PutMapping("/{id}")
    public Crop updateCrop(@PathVariable Long id, @RequestBody Crop c) {
        return cropService.updateCrop(id, c);
    }

    // Delete Crop
    @DeleteMapping("/{id}")
    public String deleteCropById(@PathVariable Long id) {
        cropService.deleteCropById(id);
        return "Crop deleted successfully";
    }
}