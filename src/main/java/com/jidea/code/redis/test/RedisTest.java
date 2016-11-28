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
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());

        //String
        jedis.set("age","180");
        System.out.println("get age:"+jedis.get("age"));

        //List
        jedis.lpush("f-list", "redis");
        jedis.lpush("f-list", "is");
        jedis.lpush("f-list", "really");
        jedis.lpush("f-list", "good");

        List<String> list  = jedis.lrange("f-list",0,5);

        for (int i = 0; i <list.size(); i++) {
            System.out.println("Stored string in redis::"+list.get(i));

        }

        jedis.keys("*");


    }



}
