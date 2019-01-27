package com.scau.bbs.chat;

import com.scau.bbs.chat.server.QuarkChatServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/** @Author : xhh @Date : Create in 22:14 2019/1/12 @Email : xhhscau2015@163.com */
@SpringBootApplication
@EnableCaching // 缓存支持
@EnableDiscoveryClient
public class ChatApplication implements CommandLineRunner {
  @Autowired private QuarkChatServer server;



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
