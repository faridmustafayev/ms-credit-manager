package com.example.ms.credit.manager.controller;

import com.example.ms.credit.manager.model.request.CustomerRequest;
import com.example.ms.credit.manager.model.response.CustomerResponse;
import com.example.ms.credit.manager.service.abstraction.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveCustomer(@RequestBody CustomerRequest customer){
        customerService.saveCustomer(customer);
    }

    @GetMapping("/{pin}")
    public CustomerResponse getCustomer(@PathVariable String pin){
        return customerService.getCustomer(pin);
    }
}
