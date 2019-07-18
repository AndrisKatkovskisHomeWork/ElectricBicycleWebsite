package com.bicycles.bicycles.booking;

import com.bicycles.bicycles.accessories.Accessory;
import com.bicycles.bicycles.bicycle.Bicycle;
import com.bicycles.bicycles.calendarDay.Day;
import javax.persistence.*;
import java.util.List;

@Entity
public class Booking {

    // @ManyToOne(fetch = FetchType.LAZY)
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = ",,,")
    //  @OneToOne(fetch = FetchType.LAZY)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_booking")
    private int id;

    @OneToOne
//    @JoinColumn(name = "id_day", referencedColumnName = "id_day")
    private Day day;

    @ManyToMany
//    @JoinColumn(name = "id_acc", referencedColumnName = "id_acc")
    private List<Accessory> accessories;


    @OneToOne
//    @JoinColumn(name = "id_bicycle", referencedColumnName = "id_bicycle")
    private Bicycle bicycle;


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

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", day=" + day +
                ", accessories=" + accessories +
                ", bicycle=" + bicycle +
                '}';
    }
}
