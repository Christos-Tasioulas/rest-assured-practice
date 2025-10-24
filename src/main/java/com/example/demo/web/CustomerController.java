package com.example.demo.web;

import com.example.demo.dto.response.CustomerResponse;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        CustomerResponse customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/byLastName/{lastname}")
    public List<CustomerResponse> getCustomersByLastName(@PathVariable String lastName) {
        return customerService.getCustomerByLastname(lastName);
    }
}
