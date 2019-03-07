package com.study.demo.service;


public interface IRedisClusterDataService {

	public abstract Object clusterSave(String key, Object value);

	public abstract Object getCluster(String key);

}