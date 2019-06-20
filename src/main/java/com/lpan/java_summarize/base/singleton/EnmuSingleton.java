package com.lpan.java_summarize.base.singleton;

/**
 * ClassName: EnmuSingleton
 * Description: TODO    枚举创建单例
 * Author: lpan
 * Date 20/06/19 上午 10:31
 * Version: 1.0
 */
public enum EnmuSingleton {

    INSTANCE;
    private String name;

    public static String getInstance(){
        return "string";
    }

}
