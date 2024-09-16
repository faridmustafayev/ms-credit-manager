package com.example.ms.credit.manager.mapper;

import com.example.ms.credit.manager.dao.entity.StatusHistoriesEntity;
import com.example.ms.credit.manager.model.enums.CreditStatus;

public enum StatusHistoryMapper {
    STATUS_HISTORY_MAPPER;

    public StatusHistoriesEntity buildStatusHistoriesEntity(CreditStatus status) {
        return StatusHistoriesEntity.builder()
                .status(status)
                .build();
    }
}
