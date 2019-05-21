package com.lpan.java_summarize.base.reflect;

import com.lpan.java_summarize.base.jdk8.stream.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
        createclass("com.lpan.java_summarize.base.jdk8.stream.User");
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

}
