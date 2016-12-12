package com.jidea.code.redis.test;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @author:Just
 * @create:2016-11-28 22:51
 */
public class RedisTest {
    public static void main(String args[]){
        //链接本地的服务
        Jedis jedis = new Jedis("192.168.1.140",6379);
        jedis.auth("redis");
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());

        System.out.println("get age:"+jedis.get("age"));


        jedis.save();
    }



}
