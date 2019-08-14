package com.lpan.java_summarize.eventtest;

import com.lpan.java_summarize.designpattern.springobserver.event.MyServiceEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName: EventMessageTest
 * Description: TODO
 * Author: lpan
 * Date 13/08/19 下午 07:22
 * Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventMessageTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() {
        applicationContext.publishEvent(new MyServiceEvent("成功啦！"));
    }

}
