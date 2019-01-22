package com.scau.bbs.chat;

import com.scau.bbs.chat.server.QuarkChatServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/** @Author : xhh @Date : Create in 22:14 2019/1/12 @Email : xhhscau2015@163.com */
@SpringBootApplication
@EnableCaching // 缓存支持
@EnableDiscoveryClient
public class ChatApplication implements CommandLineRunner {
  @Autowired private QuarkChatServer server;

  /*//注入一个bean，加载自定义属性文件admin.yml
  @Bean
  public static PropertySourcesPlaceholderConfigurer properties() {
    PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
    YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
    yaml.setResources(new ClassPathResource[] {new ClassPathResource("chat.yml")});
    yaml.setResources(new ClassPathResource[] {new ClassPathResource("resource.yml")});
    pspc.setProperties(yaml.getObject());
    return pspc;
  }*/
  public static void main(String[] args) {
     SpringApplication.run(ChatApplication.class,args);
  }

  @Bean
  public QuarkChatServer quarkChatServer() {
    return new QuarkChatServer();
  }


  public void run(String... strings)  {
    server.start();
  }
}
