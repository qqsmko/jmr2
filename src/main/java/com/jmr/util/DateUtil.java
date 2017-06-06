package com.jmr.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by youtao.wan on 2017/6/5.
 */
public class DateUtil {
    private static Log log = LogFactory.getLog(DateUtil.class);

    public static Date parse(String source) {
        String pattern = "";
        switch(source.length()) {
            case 4:
                pattern = "yyyy";
            case 5:
            case 9:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
            default:
                break;
            case 6:
                pattern = "yyyyMM";
                break;
            case 7:
                pattern = "yyyy-MM";
                break;
            case 8:
                pattern = "yyyyMMdd";
                break;
            case 10:
                pattern = "yyyy-MM-dd";
                break;
            case 14:
                pattern = "yyyyMMddHHmmss";
                break;
            case 19:
                pattern = "yyyy-MM-dd HH:mm:ss";
                break;
            case 23:
                pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        }

        return parse(source, pattern);
    }

    public static Date parse(String source, String pattern){
        if (StringUtils.isEmpty(source) || StringUtils.isEmpty(pattern)){
            return null;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = formatter.parse(source);
        }catch (ParseException e){
            log.error(e);
        }
        return date;
    }

    public static String toString(Date date, String pattern){
        if (date == null || StringUtils.isEmpty(pattern)){
            return "";
        }

        return toString(date, new SimpleDateFormat(pattern));
    }

    private static String toString(Date date, SimpleDateFormat formatter){
        String s = "";

        try {
            s = formatter.format(date);
        }catch (Exception e){
            log.error(e);
        }
        return s;
    }
}
