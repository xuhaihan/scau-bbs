package com.scau.bbs.chat.service;

import com.scau.bbs.common.base.BaseService;
import com.scau.bbs.common.entity.User;

/** @Author : xhh @Date : Create in 21:20 2019/1/12 @Email : xhhscau2015@163.com */
public interface ChatService extends BaseService<User> {

  /**
   * 根据Token获取用户
   *
   * @param token
   * @return
   */
  User getUserByToken(String token);

  /**
   * 验证用户
   *
   * @param id
   * @return
   */
  boolean authUser(Integer id);
}
