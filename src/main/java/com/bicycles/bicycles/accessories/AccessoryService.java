package com.bicycles.bicycles.accessories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccessoryService {

    @Autowired
    AccessoryRepository accessoryRepository;

    public List<Accessory> getAllAccessories() {
        List<Accessory> accessories = new ArrayList<>();
        accessoryRepository.findAll().forEach(accessories::add);
        return accessories;
    }

    public Accessory getAccessory(int id) {
        return accessoryRepository.findById(id).get();
    }

    public void addAccessory(Accessory accessory) {
        accessoryRepository.save(accessory);
    }

    public boolean deleteAccessory(int id) {
        try {
            accessoryRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void updateAccessory(Accessory accessory) {
        accessoryRepository.save(accessory);
    }

    public List<Accessory> sortAccessoriesASC() {
        List<Accessory> accessories = new ArrayList<>();
        accessoryRepository.findAll(Sort.by("accessoryName")).forEach(accessories::add);
        return accessories;
    }

    public List<Accessory> sortAccessoriesDESC() {
        List<Accessory> accessories = new ArrayList<>();
        accessoryRepository.findAll(Sort.by("accessoryName").descending()).forEach(accessories::add);
        return accessories;
    }

}