package com.scau.bbs.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


/**
 * Created by xhh on 2019/1/16.
 */
@SpringBootApplication
@EnableCaching//缓存支持
@EnableDiscoveryClient
@EnableFeignClients
public class RestApplication {
    public static void main(String[] args){
       SpringApplication.run(RestApplication.class,args);
    }


}

