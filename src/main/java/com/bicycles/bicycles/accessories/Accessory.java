package com.bicycles.bicycles.accessories;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Accessory {

    @Id
    @Column(name = "id_acc")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull    //// not working !!!!
    @Column(name = "accessory_name")
    private String accessoryName;

    public Accessory() {
    }

    public Accessory(@NotNull String accessoryName) {
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

    @Override
    public String toString() {
        return "Accessory{" +
                "id=" + id +
                ", accessoryName='" + accessoryName + '\'' +
                '}';
    }
}

