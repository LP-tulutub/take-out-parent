package com.shop.test;

import com.shop.AppEurekaZuul;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedHashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= AppEurekaZuul.class)
public class AnyTimeTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testGet(){
        Object obj = this.redisTemplate.opsForValue().get("ae89007e-6939-410c-bb88-75817a044c74");
        System.out.println(obj);

        LinkedHashMap<String, Object> hashMap = (LinkedHashMap) obj;
        System.out.println(hashMap);
        System.out.println(hashMap.get("username"));

    }

}
