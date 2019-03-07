package com.study.demo.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * 
*
* @Description: Redis 单机
* @ClassName: JedisClient 
* @author zhufj
* @date 2019年3月7日 上午9:51:34 
*
 */
public class JedisClient {

	private static final String host = "127.0.0.1";
	private static final JedisClient jedisClient = new JedisClient();

	/**
	 * 
	 * 私有构造函数
	 */

	private JedisClient() {
	}

	public static JedisClient getInstance() {
		return jedisClient;
	}

	private JedisPoolConfig getPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(10);
		jedisPoolConfig.setMaxTotal(100);
		jedisPoolConfig.setMaxWaitMillis(3000);
		return jedisPoolConfig;

	}

	/**
	 * 
	 * 添加
	 * 
	 * @param key
	 * 
	 * @param value
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */

	public Boolean add(String key, String value) throws Exception {
		JedisPool pool = new JedisPool(getPoolConfig(), host);
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			if (jedis.exists(key)) {
				throw new Exception(String.format("key (%s) 已存在 ", key));
			}
			jedis.set(key, value);
		} catch (Exception e) {
			throw e;
		}
		finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		pool.destroy();
		return true;

	}

	/**
	 * 
	 * 获取值
	 * 
	 * @param key
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */

	public String get(String key) throws Exception {
		JedisPool pool = new JedisPool(getPoolConfig(), host);
		Jedis jedis = null;
		String result = "";
		try {
			jedis = pool.getResource();
			result = jedis.get(key);
		} catch (Exception e) {
			throw e;
		}

		finally {
			if (jedis != null) {
				jedis.close();
			}

		}
		pool.destroy();

		return result;

	}

	public static void main(String[] args) {
		JedisClient jedisClient = JedisClient.getInstance();
		try {
			Boolean result = jedisClient.add("hello", "redis1");
			if (result) {
				System.out.println("success");
			}
			System.out.println(jedisClient.get("hello"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}