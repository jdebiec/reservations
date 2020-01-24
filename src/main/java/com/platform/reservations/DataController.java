package com.platform.reservations;

import com.platform.reservations.repository.ReservationRepository;
import com.platform.reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {


    private final ReservationRepository repository;
    private final ReservationService service;
    private DefaultWebClient webClient;
    private MongoTemplate mongoTemplate;

    @Autowired
    public DataController(ReservationRepository repository, ReservationService service, DefaultWebClient webClient, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.service = service;
        this.webClient = webClient;
        this.mongoTemplate = mongoTemplate;
    }


}
