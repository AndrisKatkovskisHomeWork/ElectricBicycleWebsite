package com.bicycles.bicycles.calendarDay;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Day {

    @Id
    @Column(name="day_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dayName;

    public Day() {
    }


    public Day(Date dayName) {
        this.dayName = dayName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDayName() {
        return dayName;
    }

    public void setDayName(Date dayName) {
        this.dayName = dayName;
    }
}

