package com.bjprowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        //创建jedis对象
        //Jedis jedis = new Jedis("192.168.160.128", 6379);
        //利用连接池
        JedisPool open = RedisUtils.open("192.168.160.128", 6379);
        Jedis jedis = open.getResource();
        Stu stu = new Stu("张三","1");
        Stu stu2 = new Stu("李四","2");
        /*Map<String,Stu> map = new HashMap<>();
        map.put("1",stu);
        map.put("2",stu2);
        jedis.hmset("student",map);*/
        jedis.set("1",stu.toString());
        jedis.set("2",stu2.toString());
        String s = jedis.get("1");
        String s1 = jedis.get("2");
        System.out.println(s);
        System.out.println(s1);
        open.close();
    }
}
