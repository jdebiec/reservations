package com.platform.reservations;

import com.platform.reservations.service.ReservationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReservationsApplication {

    /*  Podstawowa i najważniejsza klasa springowa. Zawiera jedynie metodę main(), która
    *   jest wywoływana jako pierwsza i uruchamia całą aplikację. Jej ważność określa
    *   adnotacja @SpringBootApplication
    * */

    public static void main(String[] args) {
        SpringApplication.run(ReservationsApplication.class, args);

    }

}
