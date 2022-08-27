package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Date implements Serializable {

    public static final int DAY_PER_NOT_LEAP_YEAR = 365;

    // kiem tra nam nhuan
    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }
    // dem so ngay trong thang
    public static int getDaysOfMonth(int month,int year){
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return (isLeapYear(year))? 29:28;
            default:
                return 0;
        }
    }
    // doi nam ra ngay
    public static int convertYearsToDays(int year){
        int dayInLeapYear=0;
        for (int i = 0; i <year ; i++) {
            if(isLeapYear(i)){
                dayInLeapYear++;}
        }
        return DAY_PER_NOT_LEAP_YEAR *year+dayInLeapYear;
    }
    // doi thang ra ngay
    public static int convertMonthsToDays(int month,int year){
        int days=0;
        for (int i = 0; i < month; i++) {
            days+=getDaysOfMonth(i,year);
        }
        return days;
    }
    // doi ngay ra so ngay ke tu 0/0/0
    public static int convertDateToDays(LocalDate date){
        int days= date.getDayOfMonth()+ convertMonthsToDays( date.getMonthValue(),date.getYear())+convertYearsToDays(date.getYear());
        return days;
    }
}
