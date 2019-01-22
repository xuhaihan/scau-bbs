package com.scau.bbs.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Created by lhr on 17-7-31.
 */
@SpringBootApplication
@EnableCaching//缓存支持
@EnableDiscoveryClient
public class RestApplication {
    public static void main(String[] args){
       SpringApplication.run(RestApplication.class,args);
    }


}

