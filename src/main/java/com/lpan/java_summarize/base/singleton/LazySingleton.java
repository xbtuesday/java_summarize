package com.lpan.java_summarize.base.singleton;

/**
 * ClassName: LazySingleton
 * Description: TODO  懒汉 单例模式
 *              线程不安全
 * Author: lpan
 * Date 20/06/19 上午 09:07
 * Version: 1.0
 */
public class LazySingleton {
    public static LazySingleton lazySingleton = null;

    private LazySingleton(){}

    public static LazySingleton getLazySingleton(){
        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }


}
