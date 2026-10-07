package com.village.farmercropmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.farmercropmanagement.model.Crop;
import com.village.farmercropmanagement.repo.CropRepo;

@Service
public class CropServiceImpl implements Cropservice {

    @Autowired
    CropRepo cropRepo;

    @Override
    public Crop createCrop(Crop c) {
        return cropRepo.save(c);
    }

    @Override
    public List<Crop> getAllCrops() {
        return cropRepo.findAll();
    }

    @Override
    public Crop getCropById(Long id) {
        return cropRepo.findById(id).orElse(null);
    }

    @Override
    public Crop updateCrop(Long id, Crop c) {

        Crop oldCrop = cropRepo.findById(id).orElse(null);

        if (oldCrop != null) {

            oldCrop.setFarmerName(c.getFarmerName());
            oldCrop.setCropName(c.getCropName());
            oldCrop.setSeason(c.getSeason());
            oldCrop.setLandArea(c.getLandArea());
            oldCrop.setExpectedYield(c.getExpectedYield());
            oldCrop.setLocation(c.getLocation());
            oldCrop.setStatus(c.getStatus());

            return cropRepo.save(oldCrop);
        }

        return null;
    }

    @Override
    public void deleteCropById(Long id) {
        cropRepo.deleteById(id);
    }

    @Override
    public List<Crop> getByFarmerName(String farmerName) {
        return cropRepo.findByFarmerName(farmerName);
    }

    @Override
    public List<Crop> getBySeason(String season) {
        return cropRepo.findBySeason(season);
    }

    @Override
    public List<Crop> getByLocation(String location) {
        return cropRepo.findByLocation(location);
    }

    @Override
    public List<Crop> getByStatus(String status) {
        return cropRepo.findByStatus(status);
    }
}