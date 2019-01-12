package com.fhx.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Time {

    public String getNowTime(){
        Date d=new Date();
        int y=d.getYear()+1900;
        int m=d.getMonth()+1;
        int dd=d.getDate();
        List<String> week=new ArrayList<String>();
        week.add("星期日");
        week.add("星期一");
        week.add("星期二");
        week.add("星期三");
        week.add("星期四");
        week.add("星期五");
        week.add("星期六");
        String str=y+"年"+m+"月"+dd+"日   "+week.get(d.getDay());
        return str;
    }
    public String Date2String(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        return sdf.format(date);
    }
}
