package com.bicycles.bicycles.accessories;

import javax.persistence.*;

//  {"id":"1","accessoryName":"helmet"}
//{"id":"2","accessoryName":"water"}
//{"id":"3","accessoryName":"basket"}
//{"id":"4","accessoryName":"child seat"}
//{"id":"5","accessoryName":"trailer"}

//  http://localhost:8080/accessories

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

