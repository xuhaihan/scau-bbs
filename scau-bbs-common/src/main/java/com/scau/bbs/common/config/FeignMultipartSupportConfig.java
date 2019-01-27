package com.scau.bbs.common.config;



import feign.form.FormEncoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignMultipartSupportConfig {

  @Bean
  public FormEncoder feignFormEncoder() {
    return new SpringFormEncoder();
  }

  @Bean
  public feign.Logger.Level multipartLoggerLevel() {
    return feign.Logger.Level.FULL;
  }

}
