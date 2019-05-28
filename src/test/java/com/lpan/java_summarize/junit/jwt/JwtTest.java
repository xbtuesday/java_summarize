package com.lpan.java_summarize.junit.jwt;

import com.lpan.java_summarize.jwt.JwtUtils;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * ClassName: JwtTest  jwt 单元测试
 * Description: TODO
 * Author: lpan
 * Date 19-5-23 上午11:25
 * Version: 1.0
 */

public class JwtTest {

    @Test
    public void getjwt(){
        String name = "span";
        long l = LocalDateTime.now().toInstant(ZoneOffset.UTC).getEpochSecond();
        long ll = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
        System.out.println(l);
        System.out.println("毫秒值:" + ll);
        String s = JwtUtils.create(name);
        long l1 = LocalDateTime.now().toInstant(ZoneOffset.UTC).getEpochSecond();
        long ll1 = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
        System.out.println(l1);
        System.out.println("毫秒值:" + ll1);
        System.out.println(l1-l);
        System.out.println("毫秒值差:" + (ll1-ll));
        System.out.println(s);
    }


}
