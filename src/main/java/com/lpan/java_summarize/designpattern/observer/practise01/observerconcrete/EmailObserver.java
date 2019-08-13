package com.lpan.java_summarize.designpattern.observer.practise01.observerconcrete;

import com.lpan.java_summarize.designpattern.observer.practise01.Observer;

/**
 * ClassName: EmailObserver  观察者实现类
 * Description: TODO
 * Author: lpan
 * Date 13/08/19 下午 03:21
 * Version: 1.0
 */
public class EmailObserver implements Observer {

    /**
     * Description 邮件事件
     * @author lpan
     * @date 13/08/19
     * @date 下午 03:21
     * @param  * @param
     * @return void
     */
    @Override
    public void update() {
        System.out.println("-----------发送邮件了---------");
    }
}
