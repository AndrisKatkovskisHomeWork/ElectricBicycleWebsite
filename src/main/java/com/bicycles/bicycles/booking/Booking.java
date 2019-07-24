package com.bicycles.bicycles.booking;

import com.bicycles.bicycles.accessories.Accessory;
import com.bicycles.bicycles.bicycle.Bicycle;
import com.bicycles.bicycles.calendarDay.Day;
import javax.persistence.*;
import java.util.List;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_booking")
    private int id;

    @OneToOne
    private Day day;

    @ManyToMany
    private List<Accessory> accessories;

    @OneToOne
    private Bicycle bicycle;

    private String email;

    public Booking() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
