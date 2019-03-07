package com.study.demo.service;

import java.io.Serializable;

public interface IRedisClusterDataSentinelService {

	/** 
	 * 批量删除对应的value 
	 *  
	 * @param keys 
	 */
	public abstract void remove(String... keys);

	/** 
	 * 批量删除key 
	 *  
	 * @param pattern 
	 */
	public abstract void removePattern(String pattern);

	/** 
	 * 删除对应的value 
	 *  
	 * @param key 
	 */
	public abstract void remove(String key);

	/** 
	 * 判断缓存中是否有对应的value 
	 *  
	 * @param key 
	 * @return 
	 */
	public abstract boolean exists(String key);

	/** 
	 * 读取缓存 
	 *  
	 * @param key 
	 * @return 
	 */
	public abstract Object get(String key);

	/** 
	 * 写入缓存 
	 *  
	 * @param key 
	 * @param value 
	 * @return 
	 */
	public abstract boolean set(String key, Object value);

	/** 
	 * 写入缓存 
	 *  
	 * @param key 
	 * @param value 
	 * @return 
	 */
	public abstract boolean set(String key, Object value, Long expireTime);
}