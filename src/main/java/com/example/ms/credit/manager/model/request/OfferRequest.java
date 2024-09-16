package com.example.ms.credit.manager.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OfferRequest {
    private Integer term;
    private BigDecimal interest;
    private BigDecimal monthlyPayment;
    private BigDecimal amount;
    private boolean accepted;
}
