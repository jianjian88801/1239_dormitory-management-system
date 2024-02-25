package com.xunmaw.dormitory.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date DataFormat(String dateString){
        Date date = null;
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String DataFormat(Date date){
        String dateString = null;
        try {
            dateString = df.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateString;
    }

}
