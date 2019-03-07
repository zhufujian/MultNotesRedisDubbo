package com.study.demo.service;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

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
public class RedisClusterDataSentinelService implements IRedisClusterDataSentinelService {
	@Autowired 
	private RedisTemplate<Serializable, Object> redisTemplate;  
	  
	    /* (non-Javadoc)
		 * @see com.study.demo.service.IRedisClusterDataSentinelService#remove(java.lang.String)
		 */  
	    @Override
		public void remove(final String... keys) {  
	        for (String key : keys) {  
	            remove(key);  
	        }  
	    }  
	  
	    /* (non-Javadoc)
		 * @see com.study.demo.service.IRedisClusterDataSentinelService#removePattern(java.lang.String)
		 */  
	    @Override
		public void removePattern(final String pattern) {  
	        Set<Serializable> keys = redisTemplate.keys(pattern);  
	        if (keys.size() > 0)  
	            redisTemplate.delete(keys);  
	    }  
	  
	    /* (non-Javadoc)
		 * @see com.study.demo.service.IRedisClusterDataSentinelService#remove(java.lang.String)
		 */  
	    @Override
		public void remove(final String key) {  
	        if (exists(key)) {  
	            redisTemplate.delete(key);  
	        }  
	    }  
	  
	    /* (non-Javadoc)
		 * @see com.study.demo.service.IRedisClusterDataSentinelService#exists(java.lang.String)
		 */  
	    @Override
		public boolean exists(final String key) {  
	        return redisTemplate.hasKey(key);  
	    }  
	  
	    /* (non-Javadoc)
		 * @see com.study.demo.service.IRedisClusterDataSentinelService#get(java.lang.String)
		 */  
	    @Override
		public Object get(final String key) {  
	        Object result = null;  
	        ValueOperations<Serializable, Object> operations = redisTemplate  
	                .opsForValue();  
	        result = operations.get(key);  
	        return result;  
	    }  
	  
	    /* (non-Javadoc)
		 * @see com.study.demo.service.IRedisClusterDataSentinelService#set(java.lang.String, java.lang.Object)
		 */  
	    @Override
		public boolean set(final String key, Object value) {  
	        boolean result = false;  
	        try {  
	            ValueOperations<Serializable, Object> operations = redisTemplate  
	                    .opsForValue();  
	            operations.set(key, value);  
	            result = true;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return result;  
	    }  
	  
	    /* (non-Javadoc)
		 * @see com.study.demo.service.IRedisClusterDataSentinelService#set(java.lang.String, java.lang.Object, java.lang.Long)
		 */  
	    @Override
		public boolean set(final String key, Object value, Long expireTime) {  
	        boolean result = false;  
	        try {  
	            ValueOperations<Serializable, Object> operations = redisTemplate  
	                    .opsForValue();  
	            operations.set(key, value);  
	            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);  
	            result = true;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return result;  
	    }  
	  
	  
		/*public void setRedisTemplate(  
	            RedisTemplate<Serializable, Object> redisTemplate) {  
	        this.redisTemplate = redisTemplate;  
	    }  */
}
