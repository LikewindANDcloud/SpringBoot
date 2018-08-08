package com.wind.valley.common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisClient {
    private Logger logger = LoggerFactory.getLogger(RedisClient.class);

    @Autowired
    private JedisPool jedisPool;

    public void set(String key,String value){
        Jedis jedis=null;
        try{
            logger.info("active:"+jedisPool.getNumActive());
            logger.info("idle:"+jedisPool.getNumIdle());
            logger.info("waiter:"+jedisPool.getNumWaiters());
            jedis=jedisPool.getResource();
            jedis.set(key,value);
        }catch(Exception e){
            logger.info(e.toString());
            logger.info("缓存服务器连接失败！");
        }finally {
            //返还到连接池
            jedis.close();
        }
    }

    public String get(String key){
        String value = "";
        Jedis jedis=new Jedis("192.168.8.155",6379);
        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        } catch(Exception e){
            logger.info("缓存服务器连接异常！");
        }finally {
            //返还到连接池
            jedis.close();
        }
        return value;
    }
}
