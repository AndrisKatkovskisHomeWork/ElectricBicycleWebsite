//package com.bicycles.bicycles.calendar;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class DateService {
//
//    @Autowired
//    DateCreatingRepository dateCreatingRepository;
//
//    public List<DateCreating> getAllDates(){
//        List<DateCreating> createdData = new ArrayList<>();
//        dateCreatingRepository.findAll().forEach(createdData::add);
//        return createdData;
//    }
//
//    public void addDate(DateCreating dateCreating){
//        dateCreatingRepository.save(dateCreating);
//    }
//
//
//}