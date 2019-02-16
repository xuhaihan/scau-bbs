package com.scau.bbs.admin;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;

/** Created by xhh on 2019/1/14.*/
@SpringBootApplication
@EnableCaching // 缓存支持
public class AdminApplication {

  @Bean
  public EmbeddedServletContainerCustomizer containerCustomizer() {

    return (container -> {
      ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
      ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
      ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
      container.addErrorPages(error401Page, error404Page, error500Page);
    });
  }

  //注入一个bean，加载自定义属性文件admin.yml
  @Bean
  public static PropertySourcesPlaceholderConfigurer properties() {
    PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
    YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
    yaml.setResources(new ClassPathResource[] {new ClassPathResource("admin.yml")});
    pspc.setProperties(yaml.getObject());
    return pspc;
  }

  public static void main(String[] args) {
    SpringApplication.run(AdminApplication.class, args);
  }
}
