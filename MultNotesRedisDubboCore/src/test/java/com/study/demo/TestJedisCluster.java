package com.study.demo;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class TestJedisCluster {

	// 创建一个JedisCluster对象
	@Test
	public void testJedisCluster() {

		Set<HostAndPort> nodes = new HashSet<>();

		nodes.add(new HostAndPort("127.0.0.1", 6379));
		nodes.add(new HostAndPort("127.0.0.1", 6380));
		nodes.add(new HostAndPort("127.0.0.1", 6381));
		nodes.add(new HostAndPort("127.0.0.1", 6382));
		nodes.add(new HostAndPort("127.0.0.1", 6383));
		nodes.add(new HostAndPort("127.0.0.1", 6384));
		// 在nodes中指定每个节点的地址
		// jedisCluster在系统中是单例的。
		JedisCluster jedisCluster = new JedisCluster(nodes);
		for(int i=0;i<100;i++){
			jedisCluster.set("name"+i, "zhangsan"+i);
			jedisCluster.set("value"+i, "100"+i);
		}
		for(int i=0;i<100;i++){
			String name = jedisCluster.get("name"+i);
			String value = jedisCluster.get("value");
			System.out.println(name);
			System.out.println(value);
		}
		
		
		// 系统关闭时关闭jedisCluster
		try {
			jedisCluster.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
