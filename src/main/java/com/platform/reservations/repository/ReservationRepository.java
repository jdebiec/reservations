package com.platform.reservations.repository;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends MongoRepository<Repository, ObjectId> {

    /*  Interfejs pozwalający tworzyć metody do zarządzania obiektami z bazy.
     *   Pozwala tworzyć metody na wyszukiwanie, zapisywanie, aktualizowanie itd.
     * */


}
