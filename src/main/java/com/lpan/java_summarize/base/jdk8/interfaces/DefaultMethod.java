package com.lpan.java_summarize.base.jdk8.interfaces;

public interface DefaultMethod {

    int add(int a, int b);

    default int sub(int a, int b){
        int s = a-b;
        return s;
    }

}
