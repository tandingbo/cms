package com.tanbobo.cms.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {
    public DateUtil() {

    }

    /**
     * 默认格式
     */
    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String FORMAT_DATE = "yyyy-MM-dd";
    private static final String FORMAT_DATE_HOUR = "yyyy-MM-dd HH";
    private static final String FORMAT_DATE_HOUR_MINUTE = "yyyy-MM-dd HH:mm";

    /**
     * 日期转字符串
     *
     * @param date
     * @return
     */
    public static String dateFormat(Date date) {
        return dateFormat(date, DEFAULT_FORMAT);
    }

    public static String dateFormat(Date date, String format) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
        return "";
    }
}
