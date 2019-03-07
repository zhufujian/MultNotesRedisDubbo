package com.study.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.demo.dao.RedisClusterCache;
import com.study.demo.utils.JedisClusterClient;

/**
 * 
 *
 * @Description: 只用 Jedis 自己实现注入（区别于下面的引用spring-data-redis）
 * @ClassName: RedisClusterService
 * @author zhufj
 * @date 2019年3月7日 上午10:04:55
 *
 */
@Service
public class RedisClusterService {

	public void save() throws Exception {

		// 调用 JedisClusterClient 中的方法
		JedisClusterClient jedisClusterClient = JedisClusterClient
				.getInstance();
		try {
			jedisClusterClient.SaveRedisCluster();

		} catch (Exception e) {

			throw e;

		}

	}
}
