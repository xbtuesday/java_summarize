package com.lpan.java_summarize.designpattern.springobserver.listener;

import com.lpan.java_summarize.designpattern.springobserver.event.MyServiceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyTwoMessageListener
 * Description: TODO
 * Author: lpan
 * Date 13/08/19 下午 07:20
 * Version: 1.0
 */
@Component
public class MyTwoMessageListener implements SmartApplicationListener {
    private Logger logger = LoggerFactory.getLogger(MyMessageListener.class);

    /***
     * Description  用于判断指定的事件类型  eventType  返回 boolean  只有符合制定的类型  才执行onApplicationEvent
     * @author lpan
     * @date 13/08/19
     * @date 下午 07:11
     * @param  * @param eventType
     * @return boolean
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        if (eventType == MyServiceEvent.class){
            return true;
        }
        return false;
    }

    /***
     * Description  事件中支持的目标类型  即 source  只有是支持的类型时才执行onApplicationEvent
     * @author lpan
     * @date 13/08/19
     * @date 下午 07:16
     * @param  * @param sourceType
     * @return boolean
     */
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        if (sourceType == String.class){
            return true;
        }
        return false;
    }

    /**执行顺序  数字越小 越先被执行*/
    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        Object source = event.getSource();
        logger.info("==================有序监听器Two 监听一个event事件==================");
        logger.info("当前线程："+Thread.currentThread().getName()+"监听内容：" + source);
    }
}
