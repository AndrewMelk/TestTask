package com.melkov.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by andrew on 20.05.16.
 */
public class DateUtil {

    public static String setDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String date = sdf.format(new Date());
        return date;
    }
}
