package com.scau.bbs.chat.service.impl;

import com.scau.bbs.chat.service.ChatService;
import com.scau.bbs.chat.service.RedisService;
import com.scau.bbs.common.base.BaseServiceImpl;
import com.scau.bbs.common.dao.UserDao;
import com.scau.bbs.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/** @Author : xhh @Date : Create in 21:22 2019/1/12 @Email : xhhscau2015@163.com */
@Service
public class ChatServiceImpl extends BaseServiceImpl<UserDao, User> implements ChatService {

  @Autowired private RedisService<User> redisService;

  @Value("${REDIS_USER_KEY}")
  private String REDIS_USER_KEY;

  //@Override
  public User getUserByToken(String token) {
    User user = redisService.getString(REDIS_USER_KEY + token);
    return user;
  }

  //@Override
  public boolean authUser(Integer id) {
    User user = repository.findOne(id);
    return user.getEnable() == 1;
  }
}
