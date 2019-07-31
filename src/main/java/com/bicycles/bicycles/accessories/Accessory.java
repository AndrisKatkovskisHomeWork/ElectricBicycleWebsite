package com.bicycles.bicycles.accessories;

import javax.persistence.*;

@Entity
public class Accessory {

    @Id
    @Column(name = "id_acc")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "accessory_name")
    private String accessoryName;

    public Accessory() {
    }

    public Accessory(String accessoryName) {
        this.accessoryName = accessoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccessoryName() {
        return accessoryName;
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName;
    }
}

