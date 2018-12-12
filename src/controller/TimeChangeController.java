package controller;

import com.jfoenix.controls.JFXTimePicker;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.validator.DataValidator;

public class TimeChangeController {

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
                openNewWindow("../view/invalidData.fxml");
            }

//            try {
//                Runtime.getRuntime().exec("cmd /C time " + localTime.toString());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        });
    }

    private void openNewWindow(String filePath) {
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

}
