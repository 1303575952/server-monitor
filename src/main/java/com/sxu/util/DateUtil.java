package com.sxu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间
     *
     * @return 当前时间
     */
    public static Timestamp getNowTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATETIME_PATTERN);
        Timestamp nowTime = Timestamp.valueOf(dateFormat.format(new Date()));
        return nowTime;
    }

    /**
     * 获取当前系统时间.
     * 默认模板格式yyyy-MM-dd hh:mm:ss.
     *
     * @return 当前系统时间
     */
    public static String getCurrentDateTime() {
        return getCurrentDateTime(DATETIME_PATTERN);
    }

    /**
     * 获取当前系统日期。
     *
     * @return 当前系统日期
     */
    public static String getCurrentDate() {
        return getCurrentDateTime(DATE_PATTERN);
    }

    /**
     * 获取当前系统时间.
     *
     * @param pattern 时间模板
     * @return 当前系统时间
     */
    public static String getCurrentDateTime(String pattern) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(cal.getTime());
    }

    /**
     * 计算dateStr对应的时间
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date getDate(String dateStr) throws ParseException {
        return getDate(dateStr, DATETIME_PATTERN);
    }

    /**
     * 根据模板pattern计算dateStr对应的时间
     *
     * @param dateStr
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date getDate(String dateStr, String pattern) throws
            ParseException {
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        date = dateFormat.parse(dateStr);
        return date;
    }

    /**
     * 将date转换为yyyy-MM-dd形式
     *
     * @param date
     * @return
     */
    public static String getDateString(Date date) {
        return getString(date, DATE_PATTERN);
    }

    /**
     * 将date转换为yyyy-MM-dd HH:mm:ss形式
     *
     * @param date
     * @return
     */
    public static String getDateTimeString(Date date) {
        return getString(date, DATETIME_PATTERN);
    }

    /**
     * 根据pattern转换date
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String getString(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * 获取date的时
     *
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    /**
     * 计算两个时间的间隔秒数
     *
     * @param day1
     * @param day2
     * @return
     */
    public static long secsOf2Day(String day1, String day2) {
        try {
            Date date1 = getDate(day1);
            Date date2 = getDate(day2);
            long secs = Math.abs(date1.getTime() - date2.getTime()) / 1000;
            return secs;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 获取距datetimes的day天前日期
     *
     * @param datetimes
     * @param day
     * @return
     */
    public static String getDateBefore(String datetimes, int day) {
        Calendar now = Calendar.getInstance();
        try {
            now.setTime(getDate(datetimes));
        } catch (ParseException e) {
            logger.error("时间格式 [ " + datetimes + " ]  无法被解析：" + e.toString());
            return null;
        }
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return getString(now.getTime(), DATETIME_PATTERN);
    }
}
