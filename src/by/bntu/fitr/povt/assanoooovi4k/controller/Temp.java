package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.model.TimeZoneList;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Temp {

    public static void main(String[] args) throws IOException {
//        String strTimeToSet = "18:24";
//        //Runtime.getRuntime().exec("cmd /C date " + strDateToSet); // dd-MM-yy
//        Runtime.getRuntime().exec("cmd /C time " + strTimeToSet); // hh:mm:ss
//        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "time 10:05");
//        builder.start();


//        Set<String> allZones = ZoneId.getAvailableZoneIds();
//        List<String> zoneList = new ArrayList<String>(allZones);
//        LocalDateTime dt = LocalDateTime.now();
//        Collections.sort(zoneList);
//
//        for (String s : zoneList) {
//            ZoneId zoneId = ZoneId.of(s);
//            System.out.println(zoneId);
//            ZonedDateTime zonedDateTime = dt.atZone(zoneId);
//            ZoneOffset offset = zonedDateTime.getOffset();
//            DateTimeFormatter offsetFormatter = DateTimeFormatter.ofPattern("xxx");
//
//            System.out.println(zoneId + " " + offsetFormatter.format(offset));
//        }

        List<TimeZoneList.TimeZoneWithDisplayNames> returnedZones = TimeZoneList.getInstance().getTimeZones();
        for (TimeZoneList.TimeZoneWithDisplayNames zone : returnedZones) {
            System.out.println(zone.getStandardDisplayName());
        }
    }
}
