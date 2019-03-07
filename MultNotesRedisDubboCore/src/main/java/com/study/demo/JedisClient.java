package com.study.demo;

public interface JedisClient {

	public abstract String set(String key, String value);

	public abstract String get(String key);

	public abstract Long hset(String key, String item, String value);

	public abstract String hget(String key, String item);

	public abstract Long incr(String key);

	public abstract Long decr(String key);

	public abstract Long expire(String key, int second);

	public abstract Long ttl(String key);

}