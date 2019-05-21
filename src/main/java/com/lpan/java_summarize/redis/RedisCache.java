package com.lpan.java_summarize.redis;

import java.lang.annotation.*;


/**
 *
 *  自带注解:jdk自带注解：是从jdk1.5开始的
 * @Overrider： 告诉编译器  我重写了方法
 * @Deprecated: 告诉编译器 这个方法过时了，不建议使用
 * @SuppressWarnings：关闭方法中的警告
 *
 * 注解(Annotation) 相当于一种标记，在程序中加入注解就等于为程序打上某种标记，没有加，则等于没有任何标记，以后，javac编译器，开发工具和
 * 其他程序可以通过反射来了解你的类及各元素上有无任何标记，看你的程序标记什么，就去干相应的事，标记可以加在包，类，属性，方法的参数及局部变量上。
 *
 *  自定义注解：
 *      元注解：元注解就是我们用来注解其他注解，一般我们使用自定义注解时就需要使用元注解来标注我们自己的注解。一般有四个元注解
 *      1、@Target
 *          @Target 元注解决定了一个注解可以标识到那些成分上，如标识在类上或者方法上，属性上等
 *              有一个值 value  可以取ElementType枚举的值
 *      2、@Retention
 *              Retention定义了该Annotation被保留的时间长短
 *              有一个value 值， 取值是RetentionPolicy枚举类的值
 *      3、@Documented
 *              @Documented 是一个用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化
 *      4、@Inherited
 *              @Inherited 是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类
 *
 *      具体示例  如下:
 *
 *
 */

/**
 *  ElementType枚举的值
 *      METHOD： 表示注解作用在方法上
 *      TYPE：   注解作用在类上
 *      。。。
 */
@Target({ElementType.METHOD,ElementType.TYPE})
/**
 *  RetentionPolicy枚举的值 注解作用的时期
 *      SOURCE： 源码时期  编译的时候
 *      CLASS： class文件时期
 *      RUNTIME: 运行时期  内存中
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RedisCache {

    /**添加一个值 格式：数据类型 名称（）；*/
    String value();
    /**添加一个默认值  格式： 数据类型 名称() default 默认值；*/
    String name() default "span";

    int weight() default 64;


}
