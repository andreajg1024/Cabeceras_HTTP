package com.example.cabeceras_http.model;

public class Students {
    private int id;
    private String name;
    private String email;
    private String type;
    private double price;

    // Constructor
    public Students(int id, String name, String email, String type, double price) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
        this.price = price;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
