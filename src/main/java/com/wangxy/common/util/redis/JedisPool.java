package com.wangxy.common.util.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wangxy on 2017/9/4.
 */
@Configurable
public class JedisPool {


    private Logger log =
            LoggerFactory.getLogger(JedisPool.class);

    @Autowired
    private JedisConfiguration jedisConfiguration;

    // 分布式设计
    //主配置
    @Bean(value ="masterShardedJedisPool")
    public ShardedJedisPool masterShardedJedisPool() {
        System.out.println("-------->"+jedisConfiguration.getHost());
        JedisPoolConfig
                jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(jedisConfiguration.getMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(jedisConfiguration.getMaxWaitmillis());
        jedisPoolConfig.setTestOnBorrow(jedisConfiguration.getTestOnBorrow());
        List<JedisShardInfo> jedisShardInfos = new ArrayList<JedisShardInfo>();
        JedisShardInfo jedisShardInfo = new JedisShardInfo(
                jedisConfiguration.getHost(), jedisConfiguration.getPort(),
                jedisConfiguration.getMaxTimeout());
        jedisShardInfos.add(jedisShardInfo);
        System.out.println(jedisConfiguration.toString());
        return new
                ShardedJedisPool(jedisPoolConfig, jedisShardInfos);
    }

    //从配置
    @Bean(value = "sloyShardedJedisPool")
    public ShardedJedisPool sloyShardedJedisPool(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        //jedisPoolConfig配置
        List<JedisShardInfo> jedisShardInfos=new ArrayList<JedisShardInfo>();
        JedisShardInfo jedisShardInfo=new JedisShardInfo("url");
        jedisShardInfos.add(jedisShardInfo);
        return  new ShardedJedisPool(jedisPoolConfig,jedisShardInfos);
    }
}
