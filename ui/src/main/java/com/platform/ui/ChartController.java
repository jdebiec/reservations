package com.platform.ui;

import com.platform.reservations.DataController;
import com.platform.reservations.model.Reservation;
import com.platform.reservations.service.ReservationService;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ChartController {

    final DataController dataController;
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
    public ListView listView;
    private ReservationService service;


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


        List<Reservation> listToConvert = service.filterData(name, surname, voivodeship, costFrom,
                costTo, treatments, whichTime, disease);


        ObservableList<Reservation> listToAdd = FXCollections.observableArrayList(listToConvert);

        listToAdd.addListener((ListChangeListener) change -> {});

        if (!listView.getItems().isEmpty()) {
            listView.getItems().clear();
        }

        listView.setItems(listToAdd);

    }
}
