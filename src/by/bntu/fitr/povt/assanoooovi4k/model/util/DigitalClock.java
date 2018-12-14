package by.bntu.fitr.povt.assanoooovi4k.model.util;


import by.bntu.fitr.povt.assanoooovi4k.model.formater.DataFormatter;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.control.Label;
import java.time.LocalTime;

public class DigitalClock {

    public DigitalClock(Label label) {
//        getStylesheets().add(
//                ResourceResolver.getResourceFor(
//                        getClass(),
//                        "digital-clock.css"
//                )
//        );
        bindToTime(label);
    }

    // the digital clock updates once a second.
    private static void bindToTime(Label label) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        actionEvent -> {
                            LocalTime time = LocalTime.now();
//                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMAT_PATTERN);
//                            String string = time.format(formatter);
                            String formattedTime = DataFormatter.formatTimeForView(time);
                            label.setText(formattedTime);
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
