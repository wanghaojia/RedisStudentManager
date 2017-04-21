package com.biz.entity;

import redis.clients.jedis.Jedis;

public class MyJedis {

	private static Jedis jedis;
	
	private MyJedis(){}
	
	public synchronized static Jedis getMyJedis(){
		if (jedis == null) {
			jedis = new Jedis("localhost",6378);
		}
		return jedis;
	}
	
	public static void closeJedis(){
		if (jedis != null) {
			jedis.close();
		}
	}
}
