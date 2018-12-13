package by.bntu.fitr.povt.assanoooovi4k.model.util;

import java.time.LocalTime;

@Deprecated
public class TimeUtil {
    public static int calculateCurrentHour() {
        return LocalTime.now().getHour();
    }

    public static int calculateCurrentMinute() {
        return LocalTime.now().getMinute();
    }

    public static int calculateCurrentSecond() {
        return LocalTime.now().getSecond();
    }
}
