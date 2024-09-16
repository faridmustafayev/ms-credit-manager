package com.example.ms.credit.manager.service.abstraction;

import com.example.ms.credit.manager.model.request.CustomerRequest;
import com.example.ms.credit.manager.model.response.CustomerResponse;

public interface CustomerService {
    void saveCustomer(CustomerRequest customer);

    CustomerResponse getCustomer(String pin);
}
