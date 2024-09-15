package com.example.ms.credit.manager.mapper;

import com.example.ms.credit.manager.dao.entity.CreditEntity;
import com.example.ms.credit.manager.model.client.ConveyorRequest;
import com.example.ms.credit.manager.model.request.CreditRequest;

import static com.example.ms.credit.manager.model.enums.CreditStatus.DRAFT;

public enum CreditMapper {
    CREDIT_MAPPER;

    public ConveyorRequest buildConveyorRequest(CreditRequest credit) {
        return ConveyorRequest.builder()
                .amount(credit.getAmount())
                .monthlyPayment(credit.getMonthlyPayment())
                .interest(credit.getInterest())
                .term(credit.getTerm())
                .build();
    }

    public CreditEntity buildCreditEntity(CreditRequest credit) {
        return CreditEntity.builder()
                .term(credit.getTerm())
                .interest(credit.getInterest())
                .monthlyPayment(credit.getMonthlyPayment())
                .status(DRAFT)
                .amount(credit.getAmount())
                .conveyorId(credit.getConveyorId())
                .requestedAmount(credit.getRequestedAmount())
                .build();
    }
}
