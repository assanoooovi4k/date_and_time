package by.bntu.fitr.povt.assanoooovi4k.model.util;

import by.bntu.fitr.povt.assanoooovi4k.model.formater.DataFormatter;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

public class DigitalDateAndTime {
    public DigitalDateAndTime(Label label) {
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
                            LocalDateTime localDateTime = LocalDateTime.now();
                            String formattedDateTime = DataFormatter.formatDateTimeForView(localDateTime);
//                            LocalDate date = LocalDate.now();
//                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
//                            String string = date.format(formatter);
//                            String formattedDate = DataFormatter.formatDateForView(date);
                            label.setText(formattedDateTime);
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
