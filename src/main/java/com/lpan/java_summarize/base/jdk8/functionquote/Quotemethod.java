package com.lpan.java_summarize.base.jdk8.functionquote;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * 方法引用
 */
public class Quotemethod {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person0 = new Person();
        person0.setName("张三");
        Person person1 = new Person();
        person1.setName("李四");
        Person person2 = new Person();
        person2.setName("王五");
        Person person3 = new Person();
        person3.setName("赵六");
       /**构造方法引用*/
        Person person = Person.create(Person::new);
        person.setName("张三");
        System.out.println(person);
        /**类普通方法引用*/
        personList.forEach(Person::printss);
        /**类静态方法引用*/
        personList.forEach(Person::printname);
        /**实例方法引用*/
        //Person person = new Person();
        //person1.setName("李四");
        personList.forEach(person::printnormal);

        personList.forEach(System.out::println);

    }




}
