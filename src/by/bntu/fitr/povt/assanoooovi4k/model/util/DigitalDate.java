package by.bntu.fitr.povt.assanoooovi4k.model.util;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DigitalDate {
    public DigitalDate(Label label) {
//        getStylesheets().add(
//                ResourceResolver.getResourceFor(
//                        getClass(),
//                        "digital-clock.css"
//                )
//        );
        bindToTime(label);
    }

    // the digital clock updates once a second.
    private void bindToTime(Label label) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        actionEvent -> {
                            LocalDate date = LocalDate.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd/MM/yyyy");
                            String string = date.format(formatter);
                            label.setText(string);
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
