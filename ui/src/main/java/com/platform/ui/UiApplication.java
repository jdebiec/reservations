package com.platform.ui;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.platform.reservations", "com.platform.ui"})
public class UiApplication {

    //stockUi

    public static void main(String[] args) {
        Application.launch(ChartApplication.class, args);
    }

}
