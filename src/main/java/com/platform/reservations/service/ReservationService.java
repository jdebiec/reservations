package com.platform.reservations.service;

import com.mongodb.client.MongoClient;
import com.platform.reservations.model.Reservation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Service
public class ReservationService {


    private MongoRepository repository;
    private MongoTemplate template;
    private Reservation reservation;
    private MongoClient client;


    public ReservationService(MongoRepository repository, MongoTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    public void filterData(String name, String surname, String voivodeship,
            String costFrom, String costTo, String treatments,
            String reservedFrom, String reservedTo, String arrival,
            String departure, String whichTime, String disease) {

        Query query = new Query();
            query.addCriteria(Criteria.where("name").is(name))
                    .addCriteria(Criteria.where("surname").is(surname))
                    .addCriteria(Criteria.where("voivodeship").is(voivodeship))
                    .addCriteria(Criteria.where().is())
                    .addCriteria(Criteria.where().is())
                    .addCriteria(Criteria.where().is())
                    .addCriteria(Criteria.where().is())
                    .addCriteria(Criteria.where().is())
                    .addCriteria(Criteria.where().is())
                    .addCriteria(Criteria.where().is())



    }

    public List<Reservation> getFilteredList()  {

    }

}
