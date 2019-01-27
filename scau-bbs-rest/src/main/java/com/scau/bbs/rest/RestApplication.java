package com.scau.bbs.rest;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;


/**
 * Created by xhh on 2019/1/16.
 */
@SpringBootApplication
@EnableCaching//缓存支持
@EnableDiscoveryClient
@EnableFeignClients
public class RestApplication {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource[] {new ClassPathResource("rest.yml")});
        yaml.setResources(new ClassPathResource[] {new ClassPathResource("resource.yml")});
        pspc.setProperties(yaml.getObject());
        return pspc;
    }
    public static void main(String[] args){
       SpringApplication.run(RestApplication.class,args);
    }


}

