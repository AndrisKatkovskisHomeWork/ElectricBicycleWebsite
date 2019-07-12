package com.bicycles.bicycles.accessories;

import javax.persistence.*;

@Entity
public class Accessory {

    @Id
//    @Column(name="id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String accessoryName;

    public Accessory() {
    }

    public Accessory(String id, String accessoryName) {
        this.id = id;
        this.accessoryName = accessoryName;
    }


//    public Accessory(String accessoryName) {
//        this.accessoryName = accessoryName;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessoryName() {
        return accessoryName;
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName;
    }
}

