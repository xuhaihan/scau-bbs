package com.scau.bbs.porent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/** @Author xhh Create By 2019/1/15 */
@Configuration
@PropertySource(value={"classpath:resource.yml","classpath:portal.yml"})
public class PropertiesConfig {

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }
}
