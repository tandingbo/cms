package com.tanbobo.cms.base.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class DateUtil {
    /**
     * 默认格式
     */
    private static final String DEFULT_FORMAT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期转字符串
     * @param date
     * @return
     */
    public static String dateFormat(Date date) {
        return dateFormat(date, DEFULT_FORMAT_FORMAT);
    }

    public static String dateFormat(Date date, String format){
        if (date != null){
            SimpleDateFormat sdf = new SimpleDateFormat(DEFULT_FORMAT_FORMAT);
            if (StringUtils.isBlank(format)){
                sdf = new SimpleDateFormat(format);
            }
            return sdf.format(date);
        }
        return "";
    }
}
