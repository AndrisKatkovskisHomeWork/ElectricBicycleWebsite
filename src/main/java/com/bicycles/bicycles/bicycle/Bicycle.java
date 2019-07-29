package com.bicycles.bicycles.bicycle;

import javax.persistence.*;

@Entity
public class Bicycle {

    @Id
    @Column(name = "id_bicycle")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String weight;
    private String distance;

    public Bicycle() {
    }

    public Bicycle(String name, String weight, String distance) {
        this.name = name;
        this.weight = weight;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
