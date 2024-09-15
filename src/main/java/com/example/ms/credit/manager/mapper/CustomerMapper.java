package com.example.ms.credit.manager.mapper;

import com.example.ms.credit.manager.dao.entity.CustomerEntity;
import com.example.ms.credit.manager.model.request.CustomerRequest;
import com.example.ms.credit.manager.model.response.CustomerResponse;

public enum CustomerMapper {
    CUSTOMER_MAPPER;

    public CustomerEntity buildCustomerEntity(CustomerRequest customer) {
        return CustomerEntity.builder()
                .fullName(customer.getFullName())
                .pin(customer.getPin())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }

    public CustomerResponse buildCustomerResponse(CustomerEntity customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .pin(customer.getPin())
                .fullName(customer.getFullName())
                .phoneNumber(customer.getPhoneNumber())
                .createdAt(customer.getCreatedAt())
                .updatedAt(customer.getUpdatedAt())
                .build();
    }
}
