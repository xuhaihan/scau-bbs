package com.scau.bbs.porent.interceptor;

import com.scau.bbs.porent.entity.User;
import com.scau.bbs.porent.service.UserService;
import com.scau.bbs.porent.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author xhh Create By 2019/1/14
 *
 * <p>登录拦截
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

  @Autowired private UserService userService;

  @Value("${cookie_name}")
  private String cookieName;

  @Override
  public boolean preHandle(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
      throws Exception {

    String token = CookieUtils.getCookieValue(httpServletRequest, cookieName);
    if (StringUtils.isEmpty(token)) {
      // 跳转到登录页面
      httpServletResponse.sendRedirect("/user/login");
      return false;
    }
    User user = userService.getUserByApi(token);
    // 取不到用户信息
    if (ObjectUtils.isEmpty(user)) {
      // 跳转到登录页面
      httpServletResponse.sendRedirect("/user/login");
      // 返回false
      return false;
    }
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Object o,
      ModelAndView modelAndView)
      throws Exception {}

  @Override
  public void afterCompletion(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Object o,
      Exception e)
      throws Exception {}
}
