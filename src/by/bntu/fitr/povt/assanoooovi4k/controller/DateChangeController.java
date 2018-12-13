package by.bntu.fitr.povt.assanoooovi4k.controller;

import com.jfoenix.controls.JFXDatePicker;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DateChangeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button applyDateButton;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    void initialize() {
        applyDateButton.setOnAction(event -> {
            try {
                LocalDate localDate = datePicker.getValue();

//            try {
//                Runtime.getRuntime().exec("cmd /C date " + localDate.toString());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

                ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "date", localDate.toString());
                try {
                    builder.start();
                } catch (IOException e) {
                    //exception
                }

                Stage stage = (Stage) applyDateButton.getScene().getWindow();
                stage.close();
            }
            catch (NullPointerException e) {
                RootController rootController = new RootController();
                rootController.openNewWindow("../view/invalidData.fxml");
            }
        });

    }
}
