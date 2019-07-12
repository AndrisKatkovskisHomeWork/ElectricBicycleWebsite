package com.bicycles.bicycles.bicycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BicycleService {

    @Autowired
    BicycleRepository bicycleRepository;

    public List<Bicycle> getAllBicycles() {
        List<Bicycle> bicycles = new ArrayList<>();
        bicycleRepository.findAll().forEach(bicycles::add);
        return bicycles;
    }

    public Bicycle getBicycle(String id) {
        return bicycleRepository.findById(id).get();
    }

    public void addBicycle(Bicycle bicycle) {
        bicycleRepository.save(bicycle);
    }

    public void deleteBicycle(String id) {
        bicycleRepository.deleteById(id);
    }

    public void updateBicycle(Bicycle bicycle) {
        bicycleRepository.save(bicycle);
    }

}