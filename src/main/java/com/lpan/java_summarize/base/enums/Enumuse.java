package com.lpan.java_summarize.base.enums;

/**
 * ClassName: Enumuse
 * Description: TODO
 * Author: lpan
 * Date 30/05/19 上午 09:50
 * Version: 1.0
 */

public class Enumuse {
    public static void main(String[] args) {
        Week week =  Week.FRIDAY;
        //System.out.println(week);
        Week week1 = Week.valueOf("SUNDAY");
        printenumvalue();
    }

    public static void printenumvalue(){
        for (Week week: Week.values()) {
            System.out.println("week value:" + week+ "  week order:" + week.ordinal());
        }
    }

}
