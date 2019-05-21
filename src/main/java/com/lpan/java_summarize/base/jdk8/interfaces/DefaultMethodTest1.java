package com.lpan.java_summarize.base.jdk8.interfaces;

public class DefaultMethodTest1 implements DefaultMethod {
    @Override
    public int add(int a, int b) {
        return 0;
    }

    /**
     *
     * */
    @Override
    public int sub(int a, int b) {
        DefaultMethod.super.sub(a,b);
        return 0;
    }
}
