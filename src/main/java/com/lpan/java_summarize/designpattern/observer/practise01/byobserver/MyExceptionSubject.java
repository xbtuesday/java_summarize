package com.lpan.java_summarize.designpattern.observer.practise01.byobserver;

import com.lpan.java_summarize.designpattern.observer.practise01.Observer;
import com.lpan.java_summarize.designpattern.observer.practise01.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MyExceptionSubject
 * Description: TODO
 * Author: lpan
 * Date 13/08/19 下午 03:40
 * Version: 1.0
 */
public class MyExceptionSubject implements Subject {

    private Logger logger = LoggerFactory.getLogger(MyExceptionSubject.class);

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observerList.forEach(observer -> {
            observer.update();
        });
    }

    public void sendMessage(String exception){
        logger.info("错误信息：" + exception);
        this.notifyObserver();
    }

}
