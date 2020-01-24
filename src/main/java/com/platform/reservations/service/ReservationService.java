package com.platform.reservations.service;

import com.mongodb.client.MongoClient;
import com.platform.reservations.model.Reservation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

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

    public List<Reservation> filterData(String name, String surname, String voivodeship,
                                        String costFrom, String costTo, String treatments,
                                        String whichTime, String disease) {

        Query query = new Query();

        if (!name.isEmpty()) {
            query.addCriteria(Criteria.where("name").is(name));
        }
        if (!surname.isEmpty()) {
            query.addCriteria(Criteria.where("surname").is(surname));
        }
        if (!voivodeship.isEmpty()) {
            query.addCriteria(Criteria.where("voivodeship").is(voivodeship));
        }
        if (!costFrom.isEmpty() && !costTo.isEmpty()) {
            query.addCriteria(Criteria.where("cost").gt(costFrom).lt(costTo));
        }
        if (!treatments.isEmpty()) {
            query.addCriteria(Criteria.where("numberOfTreatments").is(treatments));
        }
        if (!whichTime.isEmpty()) {
            query.addCriteria(Criteria.where("whichTime").is(whichTime));
        }
        if (!disease.isEmpty()) {
            query.addCriteria(Criteria.where("disease").is(disease));
        }


        return template.find(query, Reservation.class, "reservations");
    }



}
