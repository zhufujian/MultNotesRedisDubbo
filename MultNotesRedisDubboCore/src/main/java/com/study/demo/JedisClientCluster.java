package com.study.demo;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.JedisCluster;

public class JedisClientCluster implements JedisClient {

	@Autowired
    private JedisCluster jedisCluster;
    /* (non-Javadoc)
	 * @see com.study.demo.JedisClient#set(java.lang.String, java.lang.String)
	 */
    @Override
	public String set(String key,String value) {

         return jedisCluster.set(key,value);

    }
    /* (non-Javadoc)
	 * @see com.study.demo.JedisClient#get(java.lang.String)
	 */
    @Override
	public String get(String key){

         return jedisCluster.get(key);

    }

    /* (non-Javadoc)
	 * @see com.study.demo.JedisClient#hset(java.lang.String, java.lang.String, java.lang.String)
	 */
    @Override
	public Long hset(String key,String item, String value) {

         return jedisCluster.hset(key,item,value);

    }

    /* (non-Javadoc)
	 * @see com.study.demo.JedisClient#hget(java.lang.String, java.lang.String)
	 */
    @Override
	public String hget(String key,String item) {

         return jedisCluster.hget(key,item);

    }

    /* (non-Javadoc)
	 * @see com.study.demo.JedisClient#incr(java.lang.String)
	 */
    @Override
	public Long incr(String key){

         return jedisCluster.incr(key);

    }

    /* (non-Javadoc)
	 * @see com.study.demo.JedisClient#decr(java.lang.String)
	 */
    @Override
	public Long decr(String key){

         return jedisCluster.decr(key);

    }

    /* (non-Javadoc)
	 * @see com.study.demo.JedisClient#expire(java.lang.String, int)
	 */
    @Override
	public Long expire(String key,int second){

         return jedisCluster.expire(key,second);

    }

    /* (non-Javadoc)
	 * @see com.study.demo.JedisClient#ttl(java.lang.String)
	 */
    @Override
	public Long ttl(String key){
         return jedisCluster.ttl(key);

    }
}
