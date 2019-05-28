package com.lpan.java_summarize;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName: BaseTest
 * Description: TODO
 * Author: lpan
 * Date 27/05/19 下午 07:10
 * Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("application-dev1.properties")
@Slf4j
public class BaseTest {
}
