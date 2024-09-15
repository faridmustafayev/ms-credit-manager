package com.example.ms.credit.manager.service.concrete;

import com.example.ms.credit.manager.dao.entity.CreditEntity;
import com.example.ms.credit.manager.dao.entity.CustomerEntity;
import com.example.ms.credit.manager.dao.repository.CreditRepository;
import com.example.ms.credit.manager.dao.repository.CustomerRepository;
import com.example.ms.credit.manager.exception.NotFoundException;
import com.example.ms.credit.manager.model.request.CustomerRequest;
import com.example.ms.credit.manager.model.response.CustomerResponse;
import com.example.ms.credit.manager.service.abstraction.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.ms.credit.manager.exception.ExceptionMessage.CUSTOMER_NOT_FOUND;
import static com.example.ms.credit.manager.mapper.CustomerMapper.CUSTOMER_MAPPER;

@RequiredArgsConstructor
@Slf4j
@Service
public class CustomerServiceHandler implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CreditRepository creditRepository;

    @Override
    public void saveCustomer(CustomerRequest customer) {
        log.info("ActionLog.saveCustomer.start with customer pin: {}", customer.getPin());
        var customerEntity = CUSTOMER_MAPPER.buildCustomerEntity(customer);
        customerRepository.save(customerEntity);
        log.info("ActionLog.saveCustomer.success with customer pin: {}", customer.getPin());
    }

    @Override
    public CustomerResponse getCustomer(String pin) {
        log.info("ActionLog.getCustomer.start with pin: {}", pin);
        var customer = fetchCustomerIfExist(pin);
        log.info("ActionLog.getCustomer.success with pin: {}", pin);
        return CUSTOMER_MAPPER.buildCustomerResponse(customer);
    }

    private CustomerEntity fetchCustomerIfExist(String pin) {
        return customerRepository.findByPin(pin).orElseThrow(() ->
                new NotFoundException(CUSTOMER_NOT_FOUND.getCode(), CUSTOMER_NOT_FOUND.getMessage()));
    }
}
