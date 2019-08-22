package com.lpan.java_summarize.designpattern.observer.practise01;

/**
 * ClassName: Subject  被观察者  事件模型中的事件源 负责产生事件
 * Description: TODO
 * Author: lpan
 * Date 13/08/19 下午 03:25
 * Version: 1.0
 */
public interface Subject {

    /**添加观察者*/
    void addObserver(Observer observer);

    /**移除观察者*/
    void removeObserver(Observer observer);

    /**通知观察者*/
    void notifyObserver();




}
