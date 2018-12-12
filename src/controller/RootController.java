package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

