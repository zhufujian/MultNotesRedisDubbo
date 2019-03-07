package com.study.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.study.demo.service.IRedisClusterDataService;


@RunWith(value= SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class RedisClusterDataServiceTest {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	@Autowired
	private IRedisClusterDataService redisClusterDataService;
	
	@Test 
	public void clusterSave(){ 
		logger.info("返回报文："+redisClusterDataService.clusterSave("test", "1233"));
	}
	@Test
	public void getCluster(){
		logger.info("返回报文："+JSON.toJSONString(redisClusterDataService.getCluster("test")));
	}
}
