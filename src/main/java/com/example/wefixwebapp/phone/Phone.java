package com.example.wefixwebapp.phone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    private String model;

    private String customer;

    public Phone(int id, String model, String customer) {
        this.id = id;
        this.model = model;
        this.customer = customer;
    }

    public Phone() {

    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
