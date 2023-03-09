package com.example.wefixwebapp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    public List<Service>findServiceByServiceName(String serviceName);
}
