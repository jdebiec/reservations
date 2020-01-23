package com.platform.ui;

import com.platform.reservations.DataController;
import com.platform.reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ChartController {

    //@FXML

    final DataController dataController;
    private ReservationService service;

    @Autowired
    public ChartController(DataController dataController, ReservationService service) {
        this.dataController = dataController;
        this.service = service;
    }


}
