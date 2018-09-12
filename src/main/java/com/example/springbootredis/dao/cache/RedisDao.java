package com.example.springbootredis.dao.cache;

import com.example.springbootredis.constant.RedisConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description：
 * @Auther： libo
 * @date： 2018/9/12:21:28
 */
@Slf4j
@Component
public class RedisDao {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 添加键值对到redis
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(
                    String.format(RedisConstant.TOKEN_PREFIX, key),
                    value,
                    RedisConstant.EXPIRE,
                    TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("【Redis】存放缓存发生异常");
            e.printStackTrace();
        }
    }

    /**
     * 通过key获取到value的值
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, key));
    }
}
