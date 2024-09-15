package com.example.ms.credit.manager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "Unexpected exception occurred"),
    CUSTOMER_NOT_FOUND("CUSTOMER_NOT_FOUND", "Customer not found");
    private String code;
    private String message;
}
