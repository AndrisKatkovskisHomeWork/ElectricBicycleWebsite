package com.bicycles.bicycles.bicycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public Bicycle getBicycle(int id) {
        return bicycleRepository.findById(id).get();
    }

    public void addBicycle(Bicycle bicycle) {
        bicycleRepository.save(bicycle);
    }


    public boolean deleteBicycle(int id) {
        try {
            bicycleRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public void updateBicycle(Bicycle bicycle) {
        bicycleRepository.save(bicycle);
    }

    public List<Bicycle> sortBicyclesWeightASC() {
        List<Bicycle> bicycles = new ArrayList<>();
        bicycleRepository.findAll(Sort.by("weight")).forEach((bicycles::add));
        return bicycles;
    }

    public List<Bicycle> sortBicyclesDistanceASC() {
        List<Bicycle> bicycles = new ArrayList<>();
        bicycleRepository.findAll(Sort.by("distance")).forEach((bicycles::add));
        return bicycles;
    }

    public List<Bicycle> sortBicyclesNameASC() {
        List<Bicycle> bicycles = new ArrayList<>();
        bicycleRepository.findAll(Sort.by("name")).forEach((bicycles::add));
        return bicycles;
    }
}