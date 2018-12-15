package by.bntu.fitr.povt.assanoooovi4k.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import by.bntu.fitr.povt.assanoooovi4k.model.TimeZoneList;
import by.bntu.fitr.povt.assanoooovi4k.model.formater.DataFormatter;
import by.bntu.fitr.povt.assanoooovi4k.model.util.DigitalDateAndTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
//        currentField.setText();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (TimeZoneList.TimeZoneWithDisplayNames zone : returnedZones) {
            observableList.add(zone.getDisplayName());
        }
        timeZoneBox.setItems(observableList);

        DigitalDateAndTime digitalDateAndTime = new DigitalDateAndTime(currentField);

        timeZoneBox.setOnAction(event -> {
            String string = timeZoneBox.getValue();
            for (TimeZoneList.TimeZoneWithDisplayNames zone : returnedZones) {
                if (zone.getDisplayName().equals(string)) {
                    string = zone.getTimeZone().getID() + "";
                    System.out.println(string);
                }
            }
            ZoneId zoneId = ZoneId.of(string);
            LocalDateTime localDateTime = LocalDateTime.now(zoneId);
            String newString = DataFormatter.formatDateTimeForView(localDateTime);
            newField.setText(newString);
        });


        applyTimeZoneButton.setOnAction(event -> {
            if (timeZoneBox.getValue() != null) {
                String string = timeZoneBox.getValue();
                for (TimeZoneList.TimeZoneWithDisplayNames zone : returnedZones) {
                    if (zone.getDisplayName().equals(string)) {
                        System.out.println(zone.getStandardDisplayName());
                        TimeZone.setDefault(zone.getTimeZone());
                        string = "\"" + zone.getStandardDisplayName() + "\"";;
                    }
                }
//
//                try {
//                    Runtime.getRuntime().exec("tzutil /s " + string);
//                    System.out.println(string);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

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
                rootController.openNewWindow("/view/invalidData.fxml");
            }
        });
    }
}
