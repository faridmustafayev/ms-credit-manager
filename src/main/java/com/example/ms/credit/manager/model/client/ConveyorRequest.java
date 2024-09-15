package com.example.ms.credit.manager.model.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ConveyorRequest {
    private BigDecimal amount;
    private BigDecimal monthlyPayment;
    private BigDecimal interest;
    private Integer term;
}
