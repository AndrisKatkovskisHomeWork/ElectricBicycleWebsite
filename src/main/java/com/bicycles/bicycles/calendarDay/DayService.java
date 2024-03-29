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

    public Day getDay(int id) {
        return dayRepository.findById(id).get();
    }

    public boolean addDay(Day day) {
        try {
            dayRepository.save(day);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteDay(int id) {
        try {
            dayRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void updateDay(Day day) {
        dayRepository.save(day);
    }

}