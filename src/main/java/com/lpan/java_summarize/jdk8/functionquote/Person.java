package com.lpan.java_summarize.jdk8.functionquote;

import java.util.function.Supplier;

public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("name is" + name);
    }

    public static Person create(Supplier<Person> supplier){
        return supplier.get();
    }

    public static void printname(Person person){
        System.out.println("person name is " + person.getName());
    }

    public void printnormal(Person person){
        System.out.println("normal print" + person.getName());
    }

    public void printss(){
        System.out.println("printss"+ this.toString());
    }

}
