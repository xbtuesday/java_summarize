package com.lpan.java_summarize.designpattern.springobserver.event;

import org.springframework.context.ApplicationEvent;

/**
 * ClassName: MyServiceEvent  定义一个事件
 *           ApplicationEvent  就是一个事件
 * Description: TODO
 * Author: lpan
 * Date 13/08/19 下午 06:53
 * Version: 1.0
 */
public class MyServiceEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyServiceEvent(Object source) {
        super(source);
    }
}
