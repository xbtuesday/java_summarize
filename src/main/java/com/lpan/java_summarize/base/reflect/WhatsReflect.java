package com.lpan.java_summarize.base.reflect;

import com.lpan.java_summarize.base.jdk8.stream.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ClassName: WhatsReflect   什么是反射
 *      反射通常就是JVM中运行的程序需要检测和修改运行时程序的行为的一种能力，
 *      还有一个内省的概念
 *      1、内省：指计算机程序在运行时检测对象类型的一种能力，通常也可以称作运行时类型检查
 *      2、反射：指计算机程序在运行时可以访问、检测、和修改它本身状态或行为的一种能力。
 *      可以看出 内省是反射的一个子集，有些语言支持内省但是不支持反射。如c++
 *      二、我们为什么要用反射
 *      反射能够让我们：
 *          1、运行时检测一个对象所属的类
 *          2、运行时检测一个类的字段和方法
 *          3、运行时构造一个对象
 *          4、运行时调用对象的任意一个方法
 *          5、修改构造函数，方法，字段的访问权限  AccessibleObject的setAccessible(boolean flag)方法
 *      反射是框架中常用的方法
 *      例如：Junit通过反射来查找标记为@Test注解的方法，并在单元运行时调用这些方法
 *           web框架  产品开发人员在配置文件中定义接口和类的实现。通过使用反射，框架可以快速动态地初始化所需要的类
 *           Spring框架 使用bean的配置
 *      三、反射的使用
 *
 *
 *
 *
 * Description: TODO
 * Author: lpan
 * Date 19-5-21 下午6:35
 * Version: 1.0
 */
public class WhatsReflect {

    public static void main(String[] args) {
        //Introspection(new User());
        //reflect("com.lpan.java_summarize.base.jdk8.stream.User");
        //packageandclassname(new User());
        //createclass("com.lpan.java_summarize.base.jdk8.stream.User");
        //createByconstructor("com.lpan.java_summarize.base.jdk8.stream.User");
        //invorkmethodbyclass("com.lpan.java_summarize.base.jdk8.stream.User");
        getparentinfo();
        //invorkmethodbyreflect("com.lpan.java_summarize.base.jdk8.stream.User");
        //getclassload("com.lpan.java_summarize.base.jdk8.stream.User");

    }

    /**内省   算符用于确定一个对象是否属于一个特定的类*/
    public static void Introspection(Object object){
        if (object instanceof User){
            User user = (User)object;
            user.print();
        }
    }

    /**反射  Class.forName(str)  根据类或接口的名称返回class实例对象*/
    public static void reflect(String  str){
        try {
            /**根据全类名 获取class*/
            Class<?> aClass = Class.forName(str);
            /**创建实例*/
            Object o = aClass.newInstance();
            /***/
            Method print = aClass.getDeclaredMethod("print", new Class[0]);
            print.invoke(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /***
     * Description  通过反射获取类的包名
     * @author lpan
     * @date 19-5-21
     * @date 下午7:33
     * @param  * @param object
     * @return void
     */
    public static void packageandclassname(Object object){
        String packagename = object.getClass().getPackage().getName();
        String classname = object.getClass().getName();
        System.out.println("类的包名：" + packagename + "  类的名称：" + classname);
    }

    /**验证所有的类都是Class类的实例对象*/
    public static void classs(){
        Class<?> classes = null;
        try {
            classes = Class.forName("com.lpan.java_summarize.common.user.entity.User");
            String packagename = classes.getPackage().getName();
            String classname = classes.getName();
            System.out.println("类的包名：" + packagename + "  类的名称：" + classname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**过Java反射机制，用Class 创建类对象[这也就是反射存在的意义所在]*/
    public static void createclass(String str){
        try {
            Class<?> aClass = Class.forName(str);
            User user = (User) aClass.newInstance();
            user.setName("span");
            user.setAge("19");
            System.out.println("name is " + user.getName() + "  age is "+ user.getAge());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象*/
    public static void createByconstructor(String str){
        try {
            Class<?> aClass = Class.forName(str);
            /**得到所有构造函数集合*/
            Constructor<?>[] constructors = aClass.getConstructors();
            /**根据构造获得对象实例*/
            User user = (User)constructors[0].newInstance();
            user.setName("liu");
            user.setAge("18");
            Class<?> aClass1 = Class.forName(str);
            Constructor<?>[] constructors1 = aClass1.getConstructors();
            User span = (User) constructors1[1].newInstance("span", "19");
            System.out.println("user one: name is " + user.getName() +" age is " + user.getAge());
            System.out.println("user one: name is " + span.getName() +" age is " + span.getAge());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * 根据反射获取类的属性与方法
     *
     * Field() fields() 获取类中定义的公有字段  能访问从其他类继承来的公有方法
     * DeclaredField()  DeclaredFields()  获取类中定义的所有字段 与public，private protected 无关，不能访问从其他类集成来的属性
     *
     * */
    public static void invorkmethodbyclass(String str){
        try {
            Class<?> aClass = Class.forName(str);
            User user = new User();
            user.setName("张三");
            user.setAge("20");
            user.setAddress("北京");
            user.setPhone("12345678912");
            user.setUsername("zs");
            user.setBirthday("90");

            /** 获取 类的字段*/
            Field name = aClass.getField("username");
            /**修改(设置)字段的值*/
            name.set(user,"lisi");
            /**获取字段的值*/
            Object o = name.get(user);
            System.out.println("username is :" + o);
            /***/
            Field[] fields = aClass.getFields();
            Arrays.asList(fields).forEach(field -> {
                System.out.println(field.getName());
            });
            /***/
            Field[] declaredFields = aClass.getDeclaredFields();
            Arrays.asList(declaredFields).forEach(declaredField->{
                System.out.println(declaredField.getName() + "-----" + declaredField.getType());
            });
            /***/
            Field age = aClass.getDeclaredField("age");
            /**
             *   setAccessible(boolean boolean) 方法：
             *   在有setAccessible(true) 时  可以获取字段的值或修改字段的值
             *   如果没有setAccessible(true)时获取和修改字段值会报错
             *   明确一点： setAccessible(true)  并不是标识方法或字段能否被访问， public 方法的Accessible仍为false
             *   Accessible 属性是继承AccessibleObject  功能是启用或禁用安全检查
             *   值为true时 指示反射的对象在使用时取消java语言的访问检查
             *   为false时 指示反射的对象在使用的时候需要进行java语言的访问检查
             */
            age.setAccessible(true);
            age.set(user,"16");
            Object o1 = age.get(user);
            System.out.println("age is :" + o1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**过Java反射机制得到类的一些属性： 继承的接口，父类，函数信息，成员信息，类型等*/
    public static void getparentinfo(){
        String classstr = "com.lpan.java_summarize.common.user.entity.User";
        try {
            Class<?> aClass = Class.forName(classstr);
            /**获取父类*/
            Class<?> superclass = aClass.getSuperclass();
            String name = superclass.getName();
            /**父类字段*/
            Field[] declaredFields = superclass.getDeclaredFields();
            System.out.println(declaredFields.length);
            System.out.println("父类名: " + name);
            System.out.println("==========================================");

            Class<?>[] interfaces = aClass.getInterfaces();
            Class interfacec = interfaces[0];
            String name1 = interfacec.getName();
            System.out.println("实现的接口名称: " + name1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /** 通过Java反射机制调用类方法 */
    public static void invorkmethodbyreflect(String str){
        try {
            Class<?> aClass = Class.forName(str);
            User user = (User)aClass.newInstance();

            /**调用公有方法*/
            Method print = aClass.getDeclaredMethod("print");
            Object invoke = print.invoke(user);
            System.out.println(invoke);

            /**调用私有方法*/
            Method plusOne = aClass.getDeclaredMethod("plusOne", int.class);
            plusOne.setAccessible(true);
            Object invoke1 = plusOne.invoke(user, 2);
            System.out.println(invoke1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**获取类加载器*/
    public static void getclassload(String str){
        try {
            Class<?> aClass = Class.forName(str);
            /**获取类加载器*/
            String name = aClass.getClassLoader().getClass().getName();
            System.out.println(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }





}
