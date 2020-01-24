package com.platform.ui;

import com.platform.reservations.DataController;
import com.platform.reservations.model.Reservation;
import com.platform.reservations.service.ReservationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ChartController {

    final DataController dataController;
    private ReservationService service;

    @FXML
    public TextField nameField;
    @FXML
    public TextField surnameField;
    @FXML
    public TextField priceFromField;
    @FXML
    public TextField priceToField;
    @FXML
    public TextField voivodeshipField;
    @FXML
    public TextField diseaseField;
    @FXML
    public TextField whichTimeField;
    @FXML
    public TextField treatmentsField;
    @FXML
    public Button searchButton;
    @FXML
    public ListView<Reservation> listView;


    @Autowired
    public ChartController(DataController dataController, ReservationService service) {
        this.dataController = dataController;
        this.service = service;
    }

    @FXML
    public void onButtonClick() {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String voivodeship = voivodeshipField.getText();
        String costFrom = priceFromField.getText();
        String costTo = priceToField.getText();
        String treatments = treatmentsField.getText();
        String whichTime = whichTimeField.getText();
        String disease = diseaseField.getText();

        if (name.isEmpty()){
            name = "";
        } else if (surname.isEmpty()){
            surname = "";
        } else if (voivodeship.isEmpty()){
            voivodeship = "";
        } else if (costFrom.isEmpty()) {
            costFrom = "";
        } else if(costTo.isEmpty()) {
            costTo = "";
        } else if (treatments.isEmpty()) {
            treatments = "";
        } else if (whichTime.isEmpty()) {
            whichTime = "";
        } else if (disease.isEmpty()) {
            disease = "";
        }

        List<Reservation> listToConvert = service.filterData(name, surname, voivodeship, costFrom,
                costTo, treatments, whichTime, disease);

        for (Reservation element : listToConvert) {
            System.out.println(element);

        }

      //  ObservableList<Reservation> listToAdd = FXCollections.observableArrayList(listToConvert);

       // listView.setItems(listToAdd);
    }


}
