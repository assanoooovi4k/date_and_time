package by.bntu.fitr.povt.assanoooovi4k.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.*;

import by.bntu.fitr.povt.assanoooovi4k.model.TimeZoneList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TimeZoneChangeController {
    private static List<TimeZoneList.TimeZoneWithDisplayNames> returnedZones = TimeZoneList.getInstance().getTimeZones();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button applyTimeZoneButton;

    @FXML
    private ComboBox<String> timeZoneBox;

    @FXML
    private Label newField;

    @FXML
    private Label currentField;

    @FXML
    void initialize() {
        //will fix it
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (TimeZoneList.TimeZoneWithDisplayNames zone : returnedZones) {
            observableList.add(zone.getDisplayName());
        }
        timeZoneBox.setItems(observableList);


        applyTimeZoneButton.setOnAction(event -> {
            if (timeZoneBox.getValue() != null) {
                String string = timeZoneBox.getValue();
                for (TimeZoneList.TimeZoneWithDisplayNames zone : returnedZones) {
                    if (zone.getDisplayName().equals(string)) {
                        String newString = "\"" + zone.getStandardDisplayName() + "\"";
                        System.out.println(newString);
                    }
                }

                ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "tzutil /s " + string);
                try {
                    builder.start();
                } catch (IOException e) {
                    //exception
                }

                Stage stage = (Stage) applyTimeZoneButton.getScene().getWindow();
                stage.close();
            }
            else {
                RootController rootController = new RootController();
                rootController.openNewWindow("../view/invalidData.fxml");
            }
        });
    }
}
