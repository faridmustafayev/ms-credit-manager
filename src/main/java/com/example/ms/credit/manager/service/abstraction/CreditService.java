package com.example.ms.credit.manager.service.abstraction;

import com.example.ms.credit.manager.model.request.CreditRequest;

public interface CreditService {
    void saveCredit(String pin, CreditRequest credit);
}
