package com.village.farmercropmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.village.farmercropmanagement.model.Crop;

public interface CropRepo extends JpaRepository<Crop, Long> {

    List<Crop> findByFarmerName(String farmerName);

    List<Crop> findBySeason(String season);

    List<Crop> findByLocation(String location);

    List<Crop> findByStatus(String status);
}