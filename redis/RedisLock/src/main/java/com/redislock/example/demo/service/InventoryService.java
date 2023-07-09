package com.redislock.example.demo.service;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Slf4j
public class InventoryService {

    @Value("${server.port}")
    private String port;

    public static final String PRODUCT_COUNT_KEY = "product:";

    public static final String REDIS_LOCK ="redis_lock";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private Lock lock = new ReentrantLock();

    public String sale1(String productNo) {
        String response ="";

        lock.lock();
        try{
            //1 查询库存信息
            String result =stringRedisTemplate.opsForValue().get(PRODUCT_COUNT_KEY+productNo);

            //2.判断库存信息是否足够
            Integer count =result==null?0:Integer.parseInt(result);

            //3. 扣减库存，买次减少1个
            if(count>0){
                stringRedisTemplate.opsForValue().set(PRODUCT_COUNT_KEY+productNo,String.valueOf(--count));
                response="成功卖出一个商品，库存剩余："+count;
                log.info(response+"\t"+"服务端口号"+port);
            }else{
                response="商品卖完了";
            }
        }finally {
            lock.unlock();
        }

        return response;
    }

    public String sale2(String productNo) {
        String response ="";
        //分布式锁
        String redisLock =PRODUCT_COUNT_KEY+REDIS_LOCK;
        String uuid = IdUtil.simpleUUID()+":"+Thread.currentThread().getId();

        //获取锁
        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(redisLock,uuid);
        // flag为false表示抢不到的线程
        if(!flag){
            try {
                TimeUnit.MILLISECONDS.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
            sale2(productNo);
        }else{
            try{
                //1 查询库存信息
                String result =stringRedisTemplate.opsForValue().get(PRODUCT_COUNT_KEY+productNo);

                //2.判断库存信息是否足够
                Integer count =result==null?0:Integer.parseInt(result);

                //3. 扣减库存，买次减少1个
                if(count>0){
                    stringRedisTemplate.opsForValue().set(PRODUCT_COUNT_KEY+productNo,String.valueOf(--count));
                    response="成功卖出一个商品，库存剩余："+count;
                    log.info(response+"\t"+"服务端口号"+port);
                }else{
                    response="商品卖完了";
                }
            }finally {
                // 删除锁，注意只能删除自己的
                if( stringRedisTemplate.opsForValue().get(PRODUCT_COUNT_KEY+productNo).equalsIgnoreCase(uuid)){
                    stringRedisTemplate.delete(redisLock);
                }
            }
        }
        return response;
    }


    public String sale3(String productNo) {
        String response ="";
        //分布式锁
        String redisLock =PRODUCT_COUNT_KEY+REDIS_LOCK;
        String uuid = IdUtil.simpleUUID()+":"+Thread.currentThread().getId();

        //获取锁
        while (!stringRedisTemplate.opsForValue().setIfAbsent(redisLock,uuid)){
            log.info("重试1次");
            // flag为false表示抢不到的线程
            try { TimeUnit.MILLISECONDS.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        try{
            //1 查询库存信息
            String result =stringRedisTemplate.opsForValue().get(PRODUCT_COUNT_KEY+productNo);

            //2.判断库存信息是否足够
            Integer count =result==null?0:Integer.parseInt(result);

            //3. 扣减库存，买次减少1个
            if(count>0){
                stringRedisTemplate.opsForValue().set(PRODUCT_COUNT_KEY+productNo,String.valueOf(--count));
                response="sale3成功卖出一个商品，库存剩余："+count;
                log.info(response+"\t"+"服务端口号"+port);
            }else{
                response="sale3商品卖完了";
            }
        }finally {
            // 删除锁，注意只能删除自己的
            if( stringRedisTemplate.opsForValue().get(PRODUCT_COUNT_KEY+productNo).equalsIgnoreCase(uuid)){
                stringRedisTemplate.delete(redisLock);
            }
        }
        return response;
    }


    public String sale4(String productNo) {
        String response ="";
        //分布式锁
        String redisLock =PRODUCT_COUNT_KEY+REDIS_LOCK;
        String uuid = IdUtil.simpleUUID()+":"+Thread.currentThread().getId();

        //模拟锁过期
        //stringRedisTemplate.opsForValue().setIfAbsent(redisLock,uuid,30L,TimeUnit.SECONDS);
        //获取锁
        while (!stringRedisTemplate.opsForValue().setIfAbsent(redisLock,uuid,30L,TimeUnit.SECONDS)){
            log.info("重试1次");
            // flag为false表示抢不到的线程
            try { TimeUnit.MILLISECONDS.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        try{
            //1 查询库存信息
            String result =stringRedisTemplate.opsForValue().get(PRODUCT_COUNT_KEY+productNo);

            //2.判断库存信息是否足够
            Integer count =result==null?0:Integer.parseInt(result);

            //3. 扣减库存，买次减少1个
            if(count>0){
                stringRedisTemplate.opsForValue().set(PRODUCT_COUNT_KEY+productNo,String.valueOf(--count));
                response="sale4成功卖出一个商品，库存剩余："+count;
                log.info(response+"\t"+"服务端口号"+port);
            }else{
                response="sale4商品卖完了";
            }
        }finally {
            // 删除锁，注意只能删除自己的
            if( stringRedisTemplate.opsForValue().get(PRODUCT_COUNT_KEY+productNo).equalsIgnoreCase(uuid)){
                stringRedisTemplate.delete(redisLock);
            }
        }
        return response;
    }



    public String sale5(String productNo) {
        String response ="";
        //分布式锁
        String redisLock =PRODUCT_COUNT_KEY+REDIS_LOCK;
        String uuid = IdUtil.simpleUUID()+":"+Thread.currentThread().getId();

        //获取锁
        while (!stringRedisTemplate.opsForValue().setIfAbsent(redisLock,uuid,30L,TimeUnit.SECONDS)){
            log.info("sale5重试1次");
            // flag为false表示抢不到的线程
            try { TimeUnit.MILLISECONDS.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        try{
            //1 查询库存信息
            String result =stringRedisTemplate.opsForValue().get(PRODUCT_COUNT_KEY+productNo);

            //2.判断库存信息是否足够
            Integer count =result==null?0:Integer.parseInt(result);

            //3. 扣减库存，买次减少1个
            if(count>0){
                stringRedisTemplate.opsForValue().set(PRODUCT_COUNT_KEY+productNo,String.valueOf(--count));
                response="sale5成功卖出一个商品，库存剩余："+count;
                log.info(response+"\t"+"服务端口号"+port);
            }else{
                response="sale5商品卖完了";
            }
        }finally {
            // 删除锁，注意只能删除自己的
            String luaScript =
                    "if redis.call('get',KEYS[1]) == ARGV[1] then " +
                            "return redis.call('del',KEYS[1]) " +
                            "else " +
                            "return 0 " +
                            "end";
            stringRedisTemplate.execute(new DefaultRedisScript(luaScript,Long.class), Arrays.asList(redisLock),uuid);
            log.info("执行一次删除锁操作："+PRODUCT_COUNT_KEY+productNo);

        }
        return response;
    }
}
