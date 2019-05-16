package com.lpan.java_summarize.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * ClassName: RedisCacheUtils
 * Description: TODO
 * Author: lpan
 * Date 19-5-16
 * Version: 1.0
 */
@Component
public class RedisCacheUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * Description
     * @author lpan
     * @date 19-5-16
     * @date 下午5:14
     * @param  * @param key
     * @param str
     * @return void
     */
    public void addString(String key, String str){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(key);
        boundValueOperations.set(str);
        //valueOperations.set(key,str);
    }


    public String getString(String lpan) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object o = valueOperations.get(lpan);
        return o.toString();

    }
}
