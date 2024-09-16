package com.example.ms.credit.manager.model.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private BigDecimal amount;
    private BigDecimal monthlyPayment;
    private BigDecimal interest;
    private Integer term;
    private Long productId;
}
