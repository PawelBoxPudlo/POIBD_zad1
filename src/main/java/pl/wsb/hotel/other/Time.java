package pl.wsb.hotel.other;

import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.TimeZone;

import java.util.Date;


public class Time {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private int millis;

    public Time() {
        Calendar calendar = Calendar.getInstance();
        Date later = new Date();
        calendar.setTime(later);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));

        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.hour = calendar.get(Calendar.HOUR);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        this.millis = calendar.get(Calendar.MILLISECOND);
    }

    public String getNowTime(){
        return this.hour + ":" + this.minute + ":" + this.second;
    }


}
