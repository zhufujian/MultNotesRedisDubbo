package com.study.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.demo.annotation.PerfAnalyzer;
import com.study.demo.dao.RedisClusterCache;
import com.study.demo.enums.TrxCodeEnum;

/**
 * 
*
* @Description:  spring-data-redis 包做集成 
* @ClassName: RedisClusterDataService 
* @author zhufj
* @date 2019年3月7日 上午10:31:50 
*
 */
@Service
public class RedisClusterDataService implements IRedisClusterDataService {
	@Autowired
	private RedisClusterCache redisClusterCache;

	/* (non-Javadoc)
	 * @see com.study.demo.service.IRedisClusterDataService#clusterSave(java.lang.String, java.lang.Object)
	 */
	@Override
	@PerfAnalyzer(trx=TrxCodeEnum.REDIS_SET)
	public Object clusterSave(String key, Object value) {
		redisClusterCache.put(key, value);
		return "ok";
	}

	/* (non-Javadoc)
	 * @see com.study.demo.service.IRedisClusterDataService#getCluster(java.lang.String)
	 */
	@Override
	@PerfAnalyzer(trx=TrxCodeEnum.REDIS_GET)
	public Object getCluster(String key) {
		Object val = redisClusterCache.get(key);
		return val;

	}
}
