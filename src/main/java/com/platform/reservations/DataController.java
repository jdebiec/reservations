package com.platform.reservations;

import com.platform.reservations.model.Reservation;
import com.platform.reservations.repository.ReservationRepository;
import com.platform.reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {
    /* Klasa-kontroler odpowiedzialna za wysyłanie i odbieranie zapytań RESTowych,
     *  na podstawie których będą przeprowadzane odpowiednie operacje na obiektach z bazy danych
     * np. wyszukiwanie pasujących rezerwacji po danych filtrach wyszukiwania lub
     * w razie potrzeby dodawanie nowych obiektów, usuwanie ich i aktualizacja istniejących
     * */

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


/*    @GetMapping("/find")
    public List<Reservation> getAll(){
        return service.findWithAlzheimer();
    }*/

}
