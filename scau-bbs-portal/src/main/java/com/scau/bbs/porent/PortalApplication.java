package com.scau.bbs.porent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/** @Author xhh Create By 2019/1/12 */
@SpringBootApplication
@EnableDiscoveryClient
public class PortalApplication {

  public static void main(String[] args) {
    SpringApplication.run(PortalApplication.class, args);
  }
}
