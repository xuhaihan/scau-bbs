package com.scau.bbs.porent;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.beans.Encoder;

/** @Author xhh Create By 2019/1/12 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"com.scau.bbs.common"})
public class PortalApplication {
  //注入一个bean，加载自定义属性文件admin.yml
  @Bean
  public static PropertySourcesPlaceholderConfigurer properties() {
    PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
    YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
    yaml.setResources(new ClassPathResource[] {new ClassPathResource("portal.yml")});
    yaml.setResources(new ClassPathResource[] {new ClassPathResource("resource.yml")});
    pspc.setProperties(yaml.getObject());
    return pspc;
  }



  public static void main(String[] args) {
    SpringApplication.run(PortalApplication.class, args);
  }
}
