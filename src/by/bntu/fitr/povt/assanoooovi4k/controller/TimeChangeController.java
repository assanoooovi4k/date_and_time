package by.bntu.fitr.povt.assanoooovi4k.controller;

import com.jfoenix.controls.JFXTimePicker;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TimeChangeController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button applyTimeButton;

    @FXML
    private JFXTimePicker timePicker;

    @FXML
    void initialize() {
        applyTimeButton.setOnAction(event -> {
            try {
                LocalTime localTime = timePicker.getValue();

                ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "time", localTime.toString());
                try {
                    builder.start();
                } catch (IOException e) {
                    //exception
                }

                Stage stage = (Stage) applyTimeButton.getScene().getWindow();
                stage.close();
            }
            catch (NullPointerException e) {
                RootController rootController = new RootController();
                rootController.openNewWindow("/view/invalidData.fxml");
            }

//            try {
//                Runtime.getRuntime().exec("cmd /C time " + localTime.toString());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        });
    }
}
