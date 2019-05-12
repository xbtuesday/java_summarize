package com.lpan.java_summarize.jdk8.lambda;



import com.lpan.java_summarize.jdk8.lambda.package1.MyInterface;

import java.util.Arrays;
import java.util.List;

public class Test01 {
    /***/
    public static void main(String[] args) {
        //new Thread(() -> System.out.println("123")).start();
        //intfacelambda();
        //Collectionlambda();
        maplambda();
    }

    /**
     * 使用lambda表达式---示例1
     *  一个接口,如果只有一个显式声明的抽象方法, 那么它就是一个函数接口 那么它就可以使用lambda表达式表示
     * */
    public static void  intfacelambda(){
        /**
         * Runable 接口中 只有一个run方法
         *
         * */
        Runnable runnable = () -> System.out.println("1234");

        MyInterface myInterface = (int a, int b) -> {
            int s = a + b;
            System.out.println(s);
            return s;
        };
        int tests = myInterface.tests(1, 2);
    }

    /**
     *  代替匿名内部类
     *
     * */
    public static void paramlambda(){
        new Thread(()-> System.out.println("123")).start();
    }

    /***
     * lambda 表达式 在集合上使用
     */
    public static void Collectionlambda(){
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        list.forEach(str -> {
            System.out.println(str);
         });
    }


    public static void maplambda(){
        List<String> list = Arrays.asList("100", "200", "300", "400", "500", "600");
        long count = list.stream().count();
        System.out.println(count);
        list.stream().forEach(str -> System.out.println(str));
        list.stream().map(str -> str+"1").forEach(System.out::println);
    }
}
