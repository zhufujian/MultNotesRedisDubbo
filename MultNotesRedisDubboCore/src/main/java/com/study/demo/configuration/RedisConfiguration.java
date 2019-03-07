package com.study.demo.configuration;

import java.util.Set;

import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;


public class RedisConfiguration extends RedisSentinelConfiguration{
    
    public RedisConfiguration(){}
    public RedisConfiguration(Iterable<RedisNode> sentinels){
        //notNull(sentinels, "Cannot set sentinels to 'null'.");

        Set<RedisNode> sentinels2 = getSentinels();
        if(!sentinels2.isEmpty()){
            sentinels2.clear();
        }

        for (RedisNode sentinel : sentinels) {
            addSentinel(sentinel);
        }
    }

}
