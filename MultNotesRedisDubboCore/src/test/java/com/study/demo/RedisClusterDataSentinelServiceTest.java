package com.study.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.study.demo.service.IRedisClusterDataSentinelService;


@RunWith(value= SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class RedisClusterDataSentinelServiceTest {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	@Autowired
	private IRedisClusterDataSentinelService redisClusterDataSentinelService;
	
	
	@Test 
	public void set(){ 
		logger.info("返回报文："+redisClusterDataSentinelService.set("test", "1233"));
	}
	@Test
	public void get(){
		logger.info("返回报文："+JSON.toJSONString(redisClusterDataSentinelService.get("test")));
	}
	
	
}
