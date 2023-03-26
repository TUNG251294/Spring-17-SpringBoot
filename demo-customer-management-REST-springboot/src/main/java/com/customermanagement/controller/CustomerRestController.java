package com.customermanagement.controller;

import com.customermanagement.model.Customer;
import com.customermanagement.model.dto.UpdateCustomerDto;
import com.customermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customer/list")
    public ResponseEntity<Iterable<Customer>> findAll(){
        return new ResponseEntity<>(customerService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/customer/save")
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @PostMapping("/customer/update/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody UpdateCustomerDto requestDto){
        Customer currentCustomer = customerService.findById(id).get();
        if(ObjectUtils.isEmpty(currentCustomer)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentCustomer.setName(requestDto.getName());
        currentCustomer.setCountry(requestDto.getCountry());
        customerService.save(currentCustomer);
        return new ResponseEntity<>(currentCustomer,HttpStatus.ACCEPTED);
    }

    @PostMapping("/customer/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return customerService.remove(id);
    }
}
