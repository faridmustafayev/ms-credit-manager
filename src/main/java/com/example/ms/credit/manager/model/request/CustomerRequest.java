package com.example.ms.credit.manager.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private String fullName;
    private String pin;
    private String phoneNumber;
    private CreditRequest creditRequest;
    private List<Long> creditIds;
}
