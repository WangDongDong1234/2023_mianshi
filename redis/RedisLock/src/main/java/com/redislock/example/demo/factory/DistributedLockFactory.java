package com.redislock.example.demo.factory;

import cn.hutool.core.util.IdUtil;
import com.redislock.example.demo.lock.RedisDistributeLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;

@Component
public class DistributedLockFactory
{
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private String lockName;
    private String uuid;

    /**
     * 初始化工厂就制定uuid
     */
    public DistributedLockFactory()
    {
        this.uuid = IdUtil.simpleUUID();
    }

    public Lock getDistributedLock(String lockType)
    {
        if(lockType == null) return null;

        if(lockType.equalsIgnoreCase("REDIS")){
            this.lockName = "zzyyRedisLock";
            return new RedisDistributeLock(stringRedisTemplate,lockName,uuid);
        }else if(lockType.equalsIgnoreCase("ZOOKEEPER")){
            this.lockName = "zzyyZookeeperLockNode";
            //TODO zookeeper版本的分布式锁
            return null;
        }else if(lockType.equalsIgnoreCase("MYSQL")){
            //TODO MYSQL版本的分布式锁
            return null;
        }

        return null;
    }
}
