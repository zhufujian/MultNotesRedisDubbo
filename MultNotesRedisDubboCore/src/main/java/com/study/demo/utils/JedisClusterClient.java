package com.study.demo.utils;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
*
* @Description: redis 集群
* @ClassName: JedisClusterClient 
* @author zhufj
* @date 2019年3月7日 上午9:57:35 
*
 */
public class JedisClusterClient {

	private static int count = 0;
    private static final JedisClusterClient redisClusterClient = new JedisClusterClient();

    /**

     * 私有构造函数

     */

    private JedisClusterClient() {}

 

    public static JedisClusterClient getInstance() {
        return redisClusterClient;
    }

 

    private JedisPoolConfig getPoolConfig(){

        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(1000);

        config.setMaxIdle(100);

        config.setTestOnBorrow(true);

        return config;

    }

 

    public void SaveRedisCluster() {

        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();

        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6379));

        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6380));

        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6381));

        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6382));

        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6383));

        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6384));

 

        JedisCluster jc = new JedisCluster(jedisClusterNodes,getPoolConfig());

        jc.set("cluster", "this is a redis cluster");

        String result = jc.get("cluster");

        System.out.println(result);

    }

    public static void main(String[] args) {

        JedisClusterClient jedisClusterClient = JedisClusterClient.getInstance();

        jedisClusterClient.SaveRedisCluster();

    }
}