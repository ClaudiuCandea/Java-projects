package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String firstname;
    private String lastname;
    private String country;
    private String city;
    @Column(unique = true)
    private String email;
    private String password;

    public User() {
    }

    public User(Long id, String type, String firstName, String lastName, String country, String city, String email, String password) {
        this.id = id;
        this.type = type;
        this.firstname = firstName;
        this.lastname = lastName;
        this.country = country;
        this.city = city;
        this.email = email;
        this.password = password;
    }

    public User(String type,String firstName, String lastName, String country, String city, String email, String password) {
        this.type = "client";
        this.firstname = firstName;
        this.lastname = lastName;
        this.country = country;
        this.city = city;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
