package com.example.demo.service;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public List<Customer> getAll() {
        return repo.findAll();
    }
}