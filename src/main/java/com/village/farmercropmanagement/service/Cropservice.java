package com.village.farmercropmanagement.service;

import java.util.List;

import com.village.farmercropmanagement.model.Crop;

public interface Cropservice {

    Crop createCrop(Crop c);

    List<Crop> getAllCrops();

    Crop getCropById(Long id);

    Crop updateCrop(Long id, Crop c);

    void deleteCropById(Long id);

	List<Crop> getByFarmerName(String farmerName);

	List<Crop> getBySeason(String season);

	List<Crop> getByLocation(String location);

	List<Crop> getByStatus(String status);
}