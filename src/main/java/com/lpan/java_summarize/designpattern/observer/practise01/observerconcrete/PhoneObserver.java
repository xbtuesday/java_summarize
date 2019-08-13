package com.lpan.java_summarize.designpattern.observer.practise01.observerconcrete;

import com.lpan.java_summarize.designpattern.observer.practise01.Observer;

/**
 * ClassName: PhoneObserver  观察者实现类
 * Description: TODO
 * Author: lpan
 * Date 13/08/19 下午 03:23
 * Version: 1.0
 */
public class PhoneObserver implements Observer {


    /***
     * Description  手机发短信事件
     * @author lpan
     * @date 13/08/19
     * @date 下午 03:23
     * @param  * @param
     * @return void
     */
    @Override
    public void update() {
        System.out.println("-------发短信了--------");
    }
}
