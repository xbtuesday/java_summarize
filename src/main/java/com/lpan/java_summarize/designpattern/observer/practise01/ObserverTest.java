package com.lpan.java_summarize.designpattern.observer.practise01;

import com.lpan.java_summarize.designpattern.observer.practise01.byobserver.MyExceptionSubject;
import com.lpan.java_summarize.designpattern.observer.practise01.observerconcrete.EmailObserver;
import com.lpan.java_summarize.designpattern.observer.practise01.observerconcrete.PhoneObserver;

/**
 * ClassName: ObserverTest
 * Description: TODO
 * Author: lpan
 * Date 13/08/19 下午 03:54
 * Version: 1.0
 */
public class ObserverTest {
    public static void main(String[] args) {
        /**被观察者*/
        MyExceptionSubject myExceptionSubject = new MyExceptionSubject();

        /**观察者*/
        EmailObserver emailObserver = new EmailObserver();
        PhoneObserver phoneObserver = new PhoneObserver();
        /**添加观察者*/
        myExceptionSubject.addObserver(emailObserver);
        myExceptionSubject.addObserver(phoneObserver);

        /**发布事件*/
        myExceptionSubject.sendMessage("NULLPointException");

    }
}
