package com.example.ms.credit.manager.service.concrete;

import com.example.ms.credit.manager.client.ConveyorClient;
import com.example.ms.credit.manager.dao.entity.CreditEntity;
import com.example.ms.credit.manager.dao.entity.CustomerEntity;
import com.example.ms.credit.manager.dao.entity.OfferEntity;
import com.example.ms.credit.manager.dao.entity.StatusHistoriesEntity;
import com.example.ms.credit.manager.dao.repository.CreditRepository;
import com.example.ms.credit.manager.dao.repository.CustomerRepository;
import com.example.ms.credit.manager.exception.NotFoundException;
import com.example.ms.credit.manager.model.client.ConveyorResponse;
import com.example.ms.credit.manager.model.enums.CreditStatus;
import com.example.ms.credit.manager.model.request.CreditRequest;
import com.example.ms.credit.manager.service.abstraction.CreditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.ms.credit.manager.exception.ExceptionMessage.CUSTOMER_NOT_FOUND;
import static com.example.ms.credit.manager.mapper.CreditMapper.CREDIT_MAPPER;
import static com.example.ms.credit.manager.mapper.OfferMapper.OFFER_MAPPER;
import static com.example.ms.credit.manager.mapper.StatusHistoryMapper.STATUS_HISTORY_MAPPER;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreditServiceHandler implements CreditService {
    private final CreditRepository creditRepository;
    private final ConveyorClient conveyorClient;
    private final CustomerRepository customerRepository;

    @Override
    public void saveCredit(String pin, CreditRequest credit) {
        log.info("ActionLog.saveCredit.start with credit: {}", credit);
        ConveyorResponse conveyorResponses = conveyorClient.generateOffers(CREDIT_MAPPER.buildConveyorRequest(credit));

        CustomerEntity customer = fetchCustomerIfExist(pin, customerRepository);

        List<OfferEntity> offerEntity = conveyorResponses.getProducts().stream()
                .map(OFFER_MAPPER::buildOfferEntity)
                .collect(Collectors.toList());

        StatusHistoriesEntity statusHistoriesEntity = STATUS_HISTORY_MAPPER.buildStatusHistoriesEntity(CreditStatus.DRAFT);

        CreditEntity creditEntity = CREDIT_MAPPER.buildCreditEntity(credit);
        creditEntity.setOffers(offerEntity);
        creditEntity.setStatusHistories(List.of(statusHistoriesEntity));
        creditEntity.setCustomer(customer);
        customer.setCredits(List.of(creditEntity));

        customerRepository.save(customer);
        log.info("ActionLog.saveCredit.success with credit: {}", credit);
    }

    private CustomerEntity fetchCustomerIfExist(String pin, CustomerRepository customerRepository) {
        return customerRepository.findByPin(pin).orElseThrow(()->
                new NotFoundException(CUSTOMER_NOT_FOUND.getCode(), CUSTOMER_NOT_FOUND.getMessage()));
    }
}
