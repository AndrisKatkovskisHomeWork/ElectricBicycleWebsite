package com.bicycles.bicycles.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // @Entity = for Mongo is the same  as  @Document
public class Employee {

    @Id
    @Column(name="id_employee")
    private String id;
    private String name;
    private String surname;

//    private Role role = Role.ADMIN; // enum
//    private boolean availableAtWork;

    public Employee() {
    }

    public Employee(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
