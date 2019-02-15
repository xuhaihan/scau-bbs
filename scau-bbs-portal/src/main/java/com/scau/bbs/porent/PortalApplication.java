package com.scau.bbs.porent;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;



/** @Author xhh Create By 2019/1/12 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"com.scau.bbs.common"})
public class PortalApplication {
  public static void main(String[] args) {
    SpringApplication.run(PortalApplication.class, args);
  }
}
