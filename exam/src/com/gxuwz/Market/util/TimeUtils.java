package com.gxuwz.Market.util; 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by laishaohui on 2017/8/17.
 */
public class TimeUtils {

    //TODO 都未处理输入参数

    public static String getFormatTime(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date addDay(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 2);
        return cal.getTime();
    }

    public static Date minusDay(Date date, int day) {
        return addDay(date, -day);
    }
    
    /** 
     * 根据日期获得所在周的日期  
     * @param mdate 
     * @return 
     */  
    @SuppressWarnings("deprecation")  
    public static List<Date> dateToWeek(Date mdate) {  
        int b = mdate.getDay();  
        Date fdate;  
        List<Date> list = new ArrayList<Date>();  
        Long fTime = mdate.getTime() - b * 24*3600000;  
        for(int a = 1; a <= 7; a++) {  
            fdate = new Date();  
            fdate.setTime(fTime + (a * 24*3600000)); //一周从周日开始算，则使用此方式  
            //fdate.setTime(fTime + ((a-1) * 24*3600000)); //一周从周一开始算，则使用此方式  
            list.add(a-1, fdate);  
        }  
        return list;  
    }  
    
    
    //将时间戳转为  yyyy-MM-dd HH:mm:ss
    public static String transForStr(Integer ms){  
        if(ms==null){  
            ms=0;  
        }  
        long msl=(long)ms*1000;  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        String str = "";
        if(ms!=null){  
            str=sdf.format(msl);  
        }  
        return str;  
    }  

    public static void main(String[] args) {
    	// 定义输出日期格式  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Date currentDate = new Date();  
        // 比如今天是2015-02-03  
        List<Date> days = dateToWeek(currentDate);  
        System.out.println("今天的日期: " + sdf.format(currentDate));  
        for(Date date : days) {  
            System.out.println(sdf.format(date));  
        }  
	}

}
