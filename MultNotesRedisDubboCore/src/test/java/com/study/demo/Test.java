package com.study.demo;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

public class Test {

	public static void main(String[] args) {  
        Set<String> sentinels = new HashSet<String>();  
       String hostAndPort1 = "127.0.0.1:63791";  
        //String hostAndPort1 = "192.168.1.104:26379";  
        sentinels.add(hostAndPort1);  
        String clusterName = "master-1" ; 
        //String password = "xiaozhu@123" ; //此处添加密码
        // 建立连接池配置参数
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5000);
        config.setMinIdle(8);//设置最小空闲数
        config.setMaxWaitMillis(10000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        //Idle时进行连接扫描
        config.setTestWhileIdle(true);
        //表示idle object evitor两次扫描之间要sleep的毫秒数
        config.setTimeBetweenEvictionRunsMillis(30000);
        //表示idle object evitor每次扫描的最多的对象数
        config.setNumTestsPerEvictionRun(10);
        //表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
        config.setMinEvictableIdleTimeMillis(60000);
        //JedisSentinelPool redisSentinelJedisPool = new JedisSentinelPool(clusterName,sentinels,config,password); 
        JedisSentinelPool redisSentinelJedisPool = new JedisSentinelPool(clusterName,sentinels,config);
        Jedis jedis = null;  
        try {  
            jedis = redisSentinelJedisPool.getResource(); 
            //jedis.set("key", "aaa");  
            System.out.println(jedis.get("key"));  
            System.out.println(jedis.get("bbb"));  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
        	//redisSentinelJedisPool.returnResource(jedis);
            jedis.close();  
        }  
        redisSentinelJedisPool.close();  
    }
}
