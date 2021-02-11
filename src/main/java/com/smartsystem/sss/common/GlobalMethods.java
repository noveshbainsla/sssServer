package com.smartsystem.sss.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GlobalMethods {
    public static boolean isNullEmptyString(String str){
        if(str!=null && !str.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public static Date stringToDate(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        return simpleDateFormat.parse(str);
    }

    public static String dateToString(Date date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        return simpleDateFormat.format(date);
    }
}
