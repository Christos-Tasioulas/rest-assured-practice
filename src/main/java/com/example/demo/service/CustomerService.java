package com.example.demo.service;

import com.example.demo.dto.response.CustomerResponse;
import com.example.demo.entities.Customer;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public List<CustomerResponse> getAll() {
        return repo.findAll().stream()
                .map(CustomerResponse::new)
                .collect(Collectors.toList());
    }

    public CustomerResponse getCustomerById(Long id) {
        Customer customer = repo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        return new CustomerResponse(customer);
    }

    public List<CustomerResponse> getCustomerByLastname(String lastname) {
        return repo.findByLastName(lastname).stream()
                .map(CustomerResponse::new)
                .collect(Collectors.toList());
    }
}