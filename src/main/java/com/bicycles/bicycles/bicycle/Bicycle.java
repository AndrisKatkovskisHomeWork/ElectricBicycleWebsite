package com.bicycles.bicycles.bicycle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bicycle {

    @Id
    @Column(name="id_bicycle")
    private String id;
    private String name;
    private String weight;
    private String distance;
//    private boolean available; // for "not broken";

    public Bicycle() {
    }

    public Bicycle(String id, String name, String weight, String distance) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
