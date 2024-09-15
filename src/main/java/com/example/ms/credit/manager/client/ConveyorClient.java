package com.example.ms.credit.manager.client;

import com.example.ms.credit.manager.model.client.ConveyorRequest;
import com.example.ms.credit.manager.model.client.ConveyorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "conveyor",
             url = "https://polar-lowlands-53572-4147c5b66e05.herokuapp.com/v1/credit-conveyor/offers")
public interface ConveyorClient {
    @PostMapping
    ConveyorResponse generateOffers(@RequestBody ConveyorRequest conveyor);
}
