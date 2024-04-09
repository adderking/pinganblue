package com.cele.pinganblue.springConfig;

import com.alibaba.fastjson2.support.spring6.data.redis.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisIndexedHttpSession;

/**
 * Author: kingcobra
 * create on 2023/12/28 17:38
 **/
@Configuration(proxyBeanMethods = false)
@EnableRedisIndexedHttpSession(redisNamespace = "spring:session:pinganblue")
public class RedisHttpSessionConfig {
    /**
     * spring session redis 默认使用java的序列机制序列化session,这种机制在不同的JAVA版本或者其他程序处理会出现问题，
     * 所以自定义序列化，使用fastjson将session序列化成JSON格式数据存储。
     * @return
     */
    @Bean("springSessionDefaultRedisSerializer")
    public RedisSerializer<Object> redisSerializer() {
        return new GenericFastJsonRedisSerializer();
    }
}
