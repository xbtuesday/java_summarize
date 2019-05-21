package com.lpan.java_summarize.base.jdk8.datetime;

import java.time.*;

/***
 *  首先分析下jdk8之前的时间类的缺点及问题
 *     1、jdk8之前的 java.util.Date  是线程不安全的 时间可变 可以随意修改
 *     2、设计不好，java.util.Date和java.sql.Date 两个包同时包含时间类，
 *     3、时区处理麻烦。之前的时间不提供时区支持。
 *  jdk8
 *      Local(本地) 简化了日期时间的处理，没有时区的问题
 *      Zoned(时区) 通过定制的时区处理时间日期
 *      新的java.time包含了所有处理日期，时间，时间日期，时区，时刻，过程，与时钟
 *
 *
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {
        //获取当前日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        Instant instant = localDateTime.toInstant(ZoneOffset.of("+8"));
        long epochSecond = instant.getEpochSecond();
        System.out.println(epochSecond);

        //获取当前日期
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        //解析时间
        LocalTime parse = LocalTime.parse("19:38:51");
        System.out.println(parse);

        //包含时区的日期时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        //解析包含时区的时间
        ZonedDateTime parse1 = ZonedDateTime.parse(zonedDateTime.toString());
        System.out.println(parse1);
        //获取当前时区  基础
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

    }



}
