package com.example.wefixwebapp.payment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    public List<Payment> findPaymentByCustomerName(String customerName);
}
