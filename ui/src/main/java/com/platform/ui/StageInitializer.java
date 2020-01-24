package com.platform.ui;

import com.platform.reservations.service.ReservationService;
import com.platform.ui.ChartApplication.StageReadyEvent;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
            stage.setScene(new Scene(parent, 879, 561));
            stage.setTitle(applicationTitle);


            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
