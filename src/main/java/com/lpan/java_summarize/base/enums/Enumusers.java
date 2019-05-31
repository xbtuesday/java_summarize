package com.lpan.java_summarize.base.enums;

/**
 * ClassName: Enumusers
 * Description: TODO
 * Author: lpan
 * Date 30/05/19 上午 10:48
 * Version: 1.0
 */
public class Enumusers {

    Week week;

    public Enumusers(Week week) {
        this.week = week;
    }

    public void descibe(){
        System.out.println(week);
        switch (week){
            case MONDAY:
                System.out.println("星期一");
                break;
            case TUESDAY:
                System.out.println("星期二");
                break;
            case WEDNESDAY:
                System.out.println("星期三");
                break;
            case THURSDAY:
                System.out.println("星期四");
                break;
            case FRIDAY:
                System.out.println("星期五");
                break;
            case SATURDAY:
                System.out.println("星期六");
                break;
            case SUNDAY:
                System.out.println("星期日");
                break;
        }

    }
}
