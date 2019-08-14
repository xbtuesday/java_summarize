package com.lpan.java_summarize.designpattern.springobserver.listener;

import com.lpan.java_summarize.designpattern.springobserver.event.MyServiceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyMessageListener  定义一个 监听器 监听事件
 *      spring提供了多种定义事件监听器：
 *      1、有序事件监听器 (SmartApplicationListener)：顾名思义  当多个监听器监听同一个事件时  监听器会按照事先定义好的顺序先后执行监听器 达到有序执行的目的
 *      2、无序事件监听器 (ApplicationListener)：多个监听器箭筒同一个事件时，事件被触发后无法保证这些事件的监听顺序
 *
 *
 *      异步处理：
 *          1、Springboot启动类上加 @EnableAsync
 *          2、在想要进行异步处理的方法上加 @Async
 *
 * Description: TODO
 * Author: lpan
 * Date 13/08/19 下午 06:57
 * Version: 1.0
 */
@Component
public class MyMessageListener implements ApplicationListener<ApplicationEvent> {

    private Logger logger = LoggerFactory.getLogger(MyMessageListener.class);

    @Async
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof  MyServiceEvent){
            logger.info("当前事件属于" + MyServiceEvent.class.toString());
        }
        Object source = event.getSource();
        logger.info("==================监听一个event事件=================="+"当前线程："+Thread.currentThread().getName()+"监听内容：" + source);
    }
}
