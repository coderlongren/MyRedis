package com.coderlong.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
* @author ���� : coderlong
* @version ����ʱ�䣺2018��1��3�� ����11:36:35
* ��˵��: 
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
