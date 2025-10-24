package com.example.demo.dto.response;

import com.example.demo.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerResponse{
    Long id;
    String firstName;
    String lastName;

    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
    }
}

