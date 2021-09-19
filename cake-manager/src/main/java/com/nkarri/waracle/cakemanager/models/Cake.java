package com.nkarri.waracle.cakemanager.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="CAKE")
public class Cake {
    @Id
    @Column(name="CAKE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="CAKE_NUMBER")
    @NotEmpty(message = "Please provide a Cake Number")
    private String number;

    @Column(name="NAME")
    @NotEmpty(message = "Please provide a Cake Name")
    private String name;

    @Column(name="CAKE_INFO")
    @NotEmpty(message = "Please provide Cake Info")
    private String info;

    public Cake() {
    }

    public Cake(long id, String number, String name, String info) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
