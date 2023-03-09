package com.example.wefixwebapp.phone;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    public List<Phone>findPhoneById(int id);
}
