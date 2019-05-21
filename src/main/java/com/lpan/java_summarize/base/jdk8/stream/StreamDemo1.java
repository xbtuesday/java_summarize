package com.lpan.java_summarize.base.jdk8.stream;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {

    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setName("张三");
        user.setAge("22");
        user.setAddress("北京");
        user.setSex("1");
        list.add(user);
        User user1 = new User();
        user1.setName("李四");
        user1.setAge("23");
        user1.setAddress("东京");
        user1.setSex("0");
        list.add(user1);
        User user2 = new User();
        user2.setName("王五");
        user2.setAge("24");
        user2.setAddress("西京");
        user2.setSex("1");
        list.add(user2);
        User user3 = new User();
        user3.setName("王五");
        user3.setAge("24");
        user3.setAddress("西京");
        user3.setSex("1");
        list.add(user3);

        list.stream().distinct();
        /***
         *
         * filter  过滤
         *      通过方法设置的条件过滤出元素
         *      collect（Collectors.tolList()）  将流转换位集合
         */
        System.out.println("filter-------------------------------------------");
        List<User> collect = list.stream().filter(str -> str.getSex().equals("0")).collect(Collectors.toList());
        collect.forEach(userc->{
            System.out.println(userc.getName() + "   ");
            System.out.println(userc.getAge());
        });
        /***
         *  map  map是映射
         *      映射每个元素到对应的结果
         *      distinct 是获取流中不重复的元素
         */
        System.out.println("map-------------------------------------------");
        List<String> collect1 = list.stream().map(str -> str.getName() + ":").distinct().collect(Collectors.toList());
        collect1.forEach(userm->{
            System.out.println(userm + "   ");
        });
        /***
         *   limit 获取指定数量的流
         */
        System.out.println("limit-------------------------------------------");
        List<User> collect2 = list.stream().limit(2).distinct().collect(Collectors.toList());
        collect2.forEach(userm->{
            System.out.println(userm + "   ");
        });
        /***
         *   sorted  排序
         */
        System.out.println("sorted------------------------------------------");
        List<String> collect3 = list.stream().map(str -> str.getAge()).sorted().distinct().collect(Collectors.toList());
        collect3.forEach(userm->{
            System.out.println(userm + "   ");
        });
        /***
         *   parallelStream  并行流
         */
        System.out.println("parallelStream------------------------------------------");
        long count = list.parallelStream().distinct().count();
        System.out.println(count);

        /***
         *
         * Collectors
         *  实现了很多归约操作，如将流转成集合或聚合元素等
         *
         *  还有很多其他统计的方法  如  最大值，最小值，求和，平均数等
         */
        System.out.println("+++++++++-------------------------------------------");
        list.forEach(users-> {
            System.out.print(users.getName()+"   ");
            System.out.println(users.getAge());
        });
    }


}
