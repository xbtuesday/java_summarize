package com.lpan.java_summarize.base.singleton;

/**
 * ClassName: DoubleValitSingleton
 * Description: TODO  双重检查的 单例模式
 *              在创建对象的 时候 对doubleValidateSIngleton加锁
 *              使用双重检查，validate 关键字 使线程见对doubleValidateSingleton 对所有线程可见
 *
 * Author: lpan
 * Date 20/06/19 上午 09:30
 * Version: 1.0
 */
public class DoubleValitSingleton {

    private volatile static DoubleValitSingleton doubleValitSingleton = null;

    private DoubleValitSingleton(){}

    public DoubleValitSingleton getDoubleValitSingleton(){
        if (doubleValitSingleton == null){
            synchronized(DoubleValitSingleton.class) {
                if (doubleValitSingleton == null){
                    doubleValitSingleton = new DoubleValitSingleton();
                }
            }
        }
        return doubleValitSingleton;
    }

}
