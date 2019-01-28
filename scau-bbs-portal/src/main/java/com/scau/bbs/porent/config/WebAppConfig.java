package com.scau.bbs.porent.config;

import com.scau.bbs.porent.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/** @Author xhh Create By 2019/1/16 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

  @Bean
  LoginInterceptor loginInterceptor() {
    return new LoginInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(loginInterceptor())
        .addPathPatterns(
            "/pages/index",
            "/posts/pages/add",
            "/user/pages/set",
            "/user/pages/seticon",
            "/user/pages/setpsw",
            "/user/pages/message",
            "/pages/chat");
    super.addInterceptors(registry);
  }
}
