package com.scau.bbs.porent.config;

import com.scau.bbs.porent.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/** @Author xhh Create By 2019/1/16 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

  @Autowired
  private LoginInterceptor loginInterceptor;
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(loginInterceptor)
        .addPathPatterns(
            "/posts/pages/add",
            "/user/pages/set",
            "/user/pages/seticon",
            "/user/pages/setpsw",
            "/user/pages/message",
            "/pages/chat");
    super.addInterceptors(registry);
  }
}
