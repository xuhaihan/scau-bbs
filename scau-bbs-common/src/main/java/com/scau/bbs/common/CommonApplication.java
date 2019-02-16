package com.scau.bbs.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by xhh on 2019/1/10.
 */

@SpringBootApplication
@EnableCaching//缓存支持
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }
}
