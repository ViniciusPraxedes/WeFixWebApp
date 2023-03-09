package com.example.wefixwebapp.payment;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "Transaction")
public class Payment {
    @Id
    @GeneratedValue
    private int id;
    private String customerName;
    @Column(name="amount")
    @NotNull
    private int value;
    private String serviceName;
    @Column(name="localTime")
    private LocalDateTime time;
    private boolean paid;

    public Payment(int id, String customerName, int value, String serviceName, LocalDateTime time, boolean paid) {
        this.id = id;
        this.customerName = customerName;
        this.value = value;
        this.serviceName = serviceName;
        this.time = time;
        this.paid = paid;
    }

    public Payment() {
    }


    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", value=" + value +
                ", serviceName='" + serviceName + '\'' +
                ", time=" + time +
                ", paid=" + paid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
