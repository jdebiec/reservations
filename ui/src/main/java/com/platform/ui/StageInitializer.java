package com.platform.ui;

import com.platform.reservations.model.Reservation;
import com.platform.reservations.service.ReservationService;
import com.platform.ui.ChartApplication.StageReadyEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@PropertySource(value = "classpath:application.properties", encoding = "windows-1250")
public class StageInitializer implements ApplicationListener<ChartApplication.StageReadyEvent> {

    @Value("classpath:/chart.fxml")
    private Resource chartResource;
    private String applicationTitle;
    private ApplicationContext applicationContext;
    private ReservationService service;

    public StageInitializer(@Value("${spring.application.ui.title}") String applicationTitle, ApplicationContext applicationContext, ReservationService service) {
        this.applicationTitle = applicationTitle;
        this.applicationContext = applicationContext;
        this.service = service;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(chartResource.getURL());
            fxmlLoader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
            Parent parent = fxmlLoader.load();

            Stage stage = event.getStage();
            stage.setScene(new Scene(parent, 935, 681));
            stage.setTitle(applicationTitle);

            TextField imie = new TextField("Imię");
            TextField nazwisko = new TextField("Nazwisko");
            TextField wojewodztwo = new TextField("Województwo");
            TextField cenaOd = new TextField("Cena od");
            TextField cenaDo = new TextField("Cena do");
            TextField zabiegi = new TextField("Ilość zabiegów");
            TextField dataRezerwacjiOd = new TextField("Data rezerwacji od");
            TextField dataRezerwacjiDo = new TextField("Data rezerwacji do");
            TextField przyjazd = new TextField("Data przyjazdu");
            TextField wyjazd = new TextField("Data wyjazdu");
            TextField ktoryRaz = new TextField("Który raz");
            TextField schorzenie = new TextField("Schorzenie");

            Button button = new Button("Szukaj");
            button.setOnAction(click -> {
            String name = String.valueOf(imie);
            String surname = String.valueOf(nazwisko);
            String voivodeship = String.valueOf(wojewodztwo);
            String costFrom = String.valueOf(cenaOd);
            String costTo = String.valueOf(cenaDo);
            String treatments = String.valueOf(zabiegi);
            String reservedFrom = String.valueOf(dataRezerwacjiOd);
            String reservedTo = String.valueOf(dataRezerwacjiDo);
            String arrival = String.valueOf(przyjazd);
            String departure = String.valueOf(wyjazd);
            String whichTime = String.valueOf(ktoryRaz);
            String disease = String.valueOf(schorzenie);

            service.filterData();
            });

            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
