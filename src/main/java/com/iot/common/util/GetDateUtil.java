package com.iot.common.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Created with cjr
 * @author:cjr
 * @Date: 2019/8/10
 * @Time: 15:17
 * @Description  日期转换类
 */
@Component
public class GetDateUtil {

    public Date getBeforeDate() {
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = df1.format(new Date()) + " 00:00:00";
        return dateTransform(dateString);
    }

    public Date getEndDate() {
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = df1.format(new Date()) + " 23:59:59";
        return dateTransform(dateString);
    }

    /**
     * date为yyyy-MM-dd格式，返回当日结束时间
     * @param dateS
     * @return
     */
    public Date getEndDate(String dateS) {
        String dateString = dateS + " 23:59:59";
        return dateTransform(dateString);
    }

    /**
     * date为yyyy-MM-dd格式，返回当日结束时间
     * @param dateS
     * @return
     */
    public Date getBeforeDate(String dateS) {
        String dateString = dateS + " 00:00:00";
        return dateTransform(dateString);
    }

    public Date dateTransform(String dateString) {
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = df2.parse(dateString);
            System.out.println(date);
            return date;
        }catch (ParseException e) {
            e.printStackTrace();
            return new Date(dateString);
        }

    }




    //获取某月的最后一天
    public Date getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));
        String date = new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date + "23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    //获取某月的最后一天
    public Date getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));
        String date = new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date + "00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    //获取某月天数
    public int getDaysByMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        return  cal.getActualMaximum(Calendar.DAY_OF_MONTH);

    }

    /**
     * 判断两个时间是不是同一天
     * @return
     */
    public boolean chickOneDay(Date date1, Date date2) {
        if(date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            //0,1,6为ERA，YEAR，DAY_OF_YEAR
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        }
        return false;
    }


    /**
     * 获取当前日期所在周的周一
     * @param date
     */
    public Date getWeekBegin(Date date) {
        if (date == null) {
            return new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        System.out.println(cal.getTime());

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);

        System.out.println("当前周为"+calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println(cal.getTime());
        return cal.getTime();
    }

    /**
     * 获取当前日期所在一周的全部日期
     * @param date
     * @return
     */
    public List<String> getDateToWeek(Date date){
        List<String> dateWeekList = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = "";
        //flag用来存取与当天日期的相差数
        int flag = 0;
        for(int i=1;i<8;i++){
            //新建日历
            Calendar cal = Calendar.getInstance();
            //在日历中找到当前日期
            cal.setTime(date);
            //当前日期是本周第几天，默认按照上周星期天为第一天
            flag = -cal.get(Calendar.DAY_OF_WEEK);
            //根据循环。当天与上周星期天和本周一到周五相差的天数
            cal.add(Calendar.DATE,flag+i);
            //转化格式
            time = sdf.format(cal.getTime());
            //存入list
            dateWeekList.add(time);
        }
        return dateWeekList;
    }

    /**
     * 获取本周的结束日期
     * @param date
     * @return
     */
    public Date getWeekEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getWeekBegin(date));
        cal.add(Calendar.DAY_OF_WEEK, 7);
        System.out.println(cal.getTime());
        return cal.getTime();

    }

    /**
     * String类型日期：yyyy-MM-dd转换为Date日期
     * @param date
     * @return
     */
    public Date stringToDate(String date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    /**
     * 获取date的下一天
     * @param date
     * @return
     */
    public Date getNextDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        System.out.println(cal.getTime());
        return cal.getTime();

    }

    /**
     * 根据生日计算年龄
     * 生日传入字符串类型（yyyy-MM-dd）
     * @return
     */
    public int getAge(String date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        Date brithDate = null;
        try {
            brithDate = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(df.format(new Date())) - Integer.parseInt(df.format(brithDate));
    }

//    @Test
//    public void test() {
//        dateTransform("2019-8-12 11:09:55");
//        System.out.println(getLastDayOfMonth(2019, 2));
//        System.out.println(getFirstDayOfMonth(2019, 2));
//        System.out.println(getDaysByMonth(2019, 2));

//        try{
//            System.out.println(chickOneDay(new Date(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-08-16 22:00:22")));
//        }catch (Exception e) {
//
//        }
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

//        Date date = new Date();
//        List<String> dateWeekLists = getDateToWeek(date);
//        for(String s:dateWeekLists){
//            System.out.println("s:"+s);
//        }
//        try {
//            System.out.println(getWeekBegin(simpleDateFormat.parse(simpleDateFormat.format(new Date()))));
//            System.out.println(getWeekEnd(simpleDateFormat.parse(simpleDateFormat.format(new Date()))));
//            System.out.println(getNextDay(new Date()));

//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }

}
