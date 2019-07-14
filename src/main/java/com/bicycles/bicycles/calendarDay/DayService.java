package com.bicycles.bicycles.calendarDay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DayService {

    @Autowired
    DayRepository dayRepository;

    public List<Day> getAllDays() {
        List<Day> days = new ArrayList<>();
        dayRepository.findAll().forEach(days::add);
        return days;
    }

    public Day getDay(String id) {
        return dayRepository.findById(id).get();
    }

    public void addDay(Day day) {
        dayRepository.save(day);
    }

    public void deleteDay(String id) {
        dayRepository.deleteById(id);
    }

    public void updateDay(Day day) {
        dayRepository.save(day);
    }

}