package by.bntu.fitr.povt.assanoooovi4k.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainController extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/root.fxml"));
        primaryStage.setTitle("Date and time");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();

    }
}
