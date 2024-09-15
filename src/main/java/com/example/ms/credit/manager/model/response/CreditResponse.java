package com.example.ms.credit.manager.model.response;

import com.example.ms.credit.manager.model.enums.CreditStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreditResponse {
    private CreditStatus status;
}
