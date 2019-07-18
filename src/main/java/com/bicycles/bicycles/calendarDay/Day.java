package com.bicycles.bicycles.calendarDay;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Day {

    @Id
    @Column(name="id_day")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="day_name", unique = true)
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

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", dayName=" + dayName +
                '}';
    }
}

