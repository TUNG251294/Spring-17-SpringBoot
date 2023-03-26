package com.customermanagement.service;

import com.customermanagement.model.Customer;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();
    Customer save(Customer customer);
    Optional<Customer> findById(Long id);
    boolean remove(Long id);
}
