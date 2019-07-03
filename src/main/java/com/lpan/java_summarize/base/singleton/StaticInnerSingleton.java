package com.lpan.java_summarize.base.singleton;

/**
 * ClassName: StaticInnerSingleton
 * Description: TODO   静态内部类的单例模式
 *
 * Author: lpan
 * Date 20/06/19 上午 09:30
 * Version: 1.0
 */
public class StaticInnerSingleton {

    private static StaticInnerSingleton staticInnerSingleton;

    private StaticInnerSingleton(){}

    public static final StaticInnerSingleton getInstance(){
        staticInnerSingleton = StaticInnerSingletonHolder.signletonholder;
        return staticInnerSingleton;
    }

    /**静态内部类
     *
     * 内部类 定义一个静态变量来实例化
     * */
    private static class StaticInnerSingletonHolder{
        private static final  StaticInnerSingleton signletonholder = new StaticInnerSingleton();
    }


}
