package com.example.springbootredis.dao.cache;

import com.example.springbootredis.SpringBootRedisApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

/**
 * @Description：
 * @Auther： libo
 * @date： 2018/9/12:21:35
 */
@Component
public class RedisDaoTest extends SpringBootRedisApplicationTests {

    @Autowired
    private RedisDao redisDao;

    @Test
    public void set() {
        redisDao.set("key0", "value0");
    }

    @Test
    public void get() {
        String value = redisDao.get("key0");
        Assert.assertTrue(value.equals("value0"));
    }
}