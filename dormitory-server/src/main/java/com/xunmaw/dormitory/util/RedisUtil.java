package com.xunmaw.dormitory.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis 操作工具类
 * @Author qiang
 * 2018年10月29日16:27:51
 */
@Component
public class RedisUtil<K,V> {

    @Autowired
    private RedisTemplate<K,V> redisTemplate;

    public RedisTemplate<K,V> getInstance(){
        return redisTemplate;
    }

    /**
     * 设置 String 类型 key-value
     * @param key
     * @param value
     */
    public void set(K key,V value){
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取 String 类型 key-value
     * @param key
     * @return
     */
    public K get(K key){
        return (K) redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除键值
     * @param key
     * @return
     */
    public boolean detele(K key){
        return redisTemplate.delete(key);
    }
}