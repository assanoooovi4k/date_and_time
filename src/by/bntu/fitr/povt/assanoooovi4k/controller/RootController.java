package by.bntu.fitr.povt.assanoooovi4k.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import by.bntu.fitr.povt.assanoooovi4k.model.util.DigitalClock;
import by.bntu.fitr.povt.assanoooovi4k.model.util.DigitalDate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RootController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    Button button = new Button();

    @FXML
    private Button changeTimeButton;

    @FXML
    private Button changeDateButton;

    @FXML
    private Button changeTimeZoneButton;

    @FXML
    private Label timeField;

    @FXML
    private Label dateField;

    @FXML
    private Label timeZoneField;

    @FXML
    void initialize() {
        changeTimeButton.setOnAction(event -> openNewWindow("../view/changeTime.fxml"));
        changeDateButton.setOnAction(event -> openNewWindow("../view/changeDate.fxml"));
        changeTimeZoneButton.setOnAction(event -> openNewWindow("../view/changeTimeZone.fxml"));
        DigitalClock digitalClock = new DigitalClock(timeField);
        DigitalDate digitalDate = new DigitalDate(dateField);
    }

    void openNewWindow(String filePath) {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource(filePath));
        try {
            loader.load();
        } catch (IOException e) {
            //exception
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

//
//    final Timeline digitalTime = new Timeline(
//            new KeyFrame(Duration.seconds(0),
//                    new EventHandler<ActionEvent>() {
//                        @Override public void handle(ActionEvent actionEvent) {
//                            Calendar calendar            = GregorianCalendar.getInstance();
//                            String hourString   = pad(2, '0', calendar.get(Calendar.HOUR)   == 0 ? "12" : calendar.get(Calendar.HOUR) + "");
//                            String minuteString = pad(2, '0', calendar.get(Calendar.MINUTE) + "");
//                            String secondString = pad(2, '0', calendar.get(Calendar.SECOND) + "");
//                            String ampmString   = calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
//                            timeField.setText(hourString + ":" + minuteString + ":" + secondString + " " + ampmString);
//                        }
//                    }
//            ),
//            new KeyFrame(Duration.seconds(1))
//    );


}

