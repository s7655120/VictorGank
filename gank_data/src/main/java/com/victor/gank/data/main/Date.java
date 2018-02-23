package com.victor.gank.data.main;

import com.victor.gank.common.tools.StringUtils;

/**
 * Created by Victor on 2018/2/23.
 */

public class Date {

    private int mYear;
    private int mMonth;
    private int mDay;

    public int getYear() {
        return mYear;
    }

    public void setYear(int mYear) {
        this.mYear = mYear;
    }

    public int getMonth() {
        return mMonth;
    }

    public void setMonth(int mMonth) {
        this.mMonth = mMonth;
    }

    public int getDay() {
        return mDay;
    }

    public void setDay(int mDay) {
        this.mDay = mDay;
    }

    public Date copyDate(String dateString){
        String[] dates = null;
        if (dateString.contains("-")) {
            dates = dateString.split("-");
        } else if (dateString.contains("/")) {
            dates = dateString.split("/");
        }

        if (dates != null && dates.length > 2){
            Date date = new Date();
            date.setYear(StringUtils.toInt(dates[0]));
            date.setMonth(StringUtils.toInt(dates[1]));
            date.setDay(StringUtils.toInt(dates[2]));
            return date;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Date : year = " + getYear() + ", month = " + getMonth() + ", day = " + getDay();
    }
}
