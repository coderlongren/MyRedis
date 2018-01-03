package com.coderlong.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
* @author 作者 : coderlong
* @version 创建时间：2018年1月3日 上午11:36:35
* 类说明: 
*/
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		Transaction transaction = jedis.multi();
		transaction.set("k5", "v5");
		transaction.set("k6", "v6");
		transaction.exec();
		jedis.del("k5");
		
	}

}
