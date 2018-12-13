package by.bntu.fitr.povt.assanoooovi4k.controller;

import java.io.IOException;

public class Temp {
    public static void main(String[] args) throws IOException {
//        String strTimeToSet = "18:24";
//        //Runtime.getRuntime().exec("cmd /C date " + strDateToSet); // dd-MM-yy
//        Runtime.getRuntime().exec("cmd /C time " + strTimeToSet); // hh:mm:ss
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "time 10:05");
        builder.start();
    }
}
