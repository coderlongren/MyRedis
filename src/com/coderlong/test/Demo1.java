package com.coderlong.test;

import java.util.Set;

import redis.clients.jedis.Jedis;

/**
* @author 作者 : coderlong
* @version 创建时间：2017年12月20日 下午7:03:50
* 类说明: 
*/
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("127.0.0.1",6379);
		
		System.out.println("test redis connection ----->" + jedis.ping());
//		System.out.println(jedis.keys("*"));
		Set<String> set = jedis.keys("*");
		for (String string : set) {
			System.out.println(string);
		}
//		jedis.select(1);
//		System.out.println("已经移动到 一号仓库了 ");
//		for (String string : set) {
//			System.out.println(string);
//		}
		jedis.expire("sailong", 3);
		jedis.save();
	}

}
