package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String description;
    private double pricePerNight;
    private int noFreeRooms;
    private String imagePathLocation;
    private String type;

    public Hotel() {
    }

    public Hotel(long id, String name, String address, String description, double pricePerNight, int noFreeRooms,String imagePathLocation, String type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.noFreeRooms = noFreeRooms;
        this.imagePathLocation = imagePathLocation;
        this.type = type;
    }

    public Hotel(String name, String address, String description, double pricePerNight, int noFreeRooms,String imagePathLocation, String type) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.noFreeRooms = noFreeRooms;
        this.imagePathLocation = imagePathLocation;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getNoFreeRooms() {
        return noFreeRooms;
    }

    public void setNoFreeRooms(int noFreeRooms) {
        this.noFreeRooms = noFreeRooms;
    }

    public String getImagePathLocation() {
        return imagePathLocation;
    }

    public void setImagePathLocation(String imagePathLocation) {
        this.imagePathLocation = imagePathLocation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
