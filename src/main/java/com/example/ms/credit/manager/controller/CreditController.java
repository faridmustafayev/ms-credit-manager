package com.example.ms.credit.manager.controller;

import com.example.ms.credit.manager.model.request.CreditRequest;
import com.example.ms.credit.manager.service.abstraction.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/credits")
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @PostMapping("/{pin}")
    @ResponseStatus(CREATED)
    public void saveCredit(@PathVariable String pin, @RequestBody CreditRequest credit){
        creditService.saveCredit(pin, credit);
    }
}
