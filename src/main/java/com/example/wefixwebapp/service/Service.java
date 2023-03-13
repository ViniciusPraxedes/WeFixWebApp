package com.example.wefixwebapp.service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Service {
    @Id
    @GeneratedValue
    private int id;
    private String serviceName;
    private String description;
    private String customerName;
    private String phoneModel;
    private boolean done;

    public Service(int id, String serviceName, String description, boolean done) {
        this.id = id;
        this.serviceName = serviceName;
        this.description = description;
        this.done = done;
    }

    public Service() {

    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", description='" + description + '\'' +
                ", customerName='" + customerName + '\'' +
                ", phoneModel='" + phoneModel + '\'' +
                ", done=" + done +
                '}';
    }

    public Service(int id, String serviceName, String description, String customerName, String phoneModel, boolean done) {
        this.id = id;
        this.serviceName = serviceName;
        this.description = description;
        this.customerName = customerName;
        this.phoneModel = phoneModel;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
