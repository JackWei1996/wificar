/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2018
 * FileName: RedisConfig.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name         |      Content
 * 1   | 2019年1月4日        | Aisino)Jack    | original version
 */
package com.hhit.wificar.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * class name:RedisConfig <BR>
 * class description: Redis配置类 <BR>
 * Remark: <BR>
 * @version 1.00 2019年1月4日
 * @author Aisino)weihaohao
 */
@Configuration
@EnableCaching//开启缓存管理器
public class RedisConfig {
	/**
	 * Method name: redisTemplate <BR>
	 * Description: 希望将对象类型的value序列化为JSON，而key是String类型 <BR>
	 * Remark: <BR>
	 * @param factory
	 * @return  RedisTemplate<BR>
	 */
	@Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
		// 创建一个模板类
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        // 将刚才的redis连接工厂设置到模板类中
        template.setConnectionFactory(factory);
        // 设置key的序列化器
        template.setKeySerializer(new StringRedisSerializer());
        // 设置value的序列化器
        //使用Jackson 2，将对象序列化为JSON
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //json转对象类，不设置默认的会将json转成hashmap
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);

        return template;
    }
	
	/**
            * 申明缓存管理器，会创建一个切面（aspect）并触发Spring缓存注解的切点（pointcut）
            * 根据类或者方法所使用的注解以及缓存的状态，
            * 这个切面会从缓存中获取数据，将数据添加到缓存之中或者从缓存中移除某个值
     * @return
     */
	@Bean
	public CacheManager cacheManager(RedisConnectionFactory factory) {
	    RedisCacheManager cacheManager = RedisCacheManager.create(factory);
	    return cacheManager;
	}
}
