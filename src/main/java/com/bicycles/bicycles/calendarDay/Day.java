package com.bicycles.bicycles.calendarDay;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Day {

    @Id
//    @Column(name="id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String dayName;

    public Day() {
    }

    public Day(String id, String dayName) {
        this.id = id;
        this.dayName = dayName;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }
}

