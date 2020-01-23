package com.platform.reservations.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document(collection = "reservations")
@NoArgsConstructor
public class Reservation {

    /*  Klasa z modelem obiektu przesyłanego do bazy danych. Przesyłanie odbywa się w formacie JSON
     * */

    @Id
    private String id;
    @NotNull
    private String reservationId;
    @NotNull
    private String reservationDate;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String arrivalDate;
    @NotNull
    private String departureDate;
    @NotNull
    private String cost;
    @NotNull
    private String deposit;
    @NotNull
    private String surname;
    @NotNull
    private String name;
    @NotNull
    private String voivodeship;
    @NotNull
    private String county;
    @NotNull
    private String community;
    @NotNull
    private String street;
    @NotNull
    private String buildingNumber;
    @NotNull
    private String center;
    @NotNull
    private String roomNumber;
    @NotNull
    private String zipCode;
    @NotNull
    private String numberofTreatments;
    @NotNull
    private String disease;
    @NotNull
    private String whichTime;

}
