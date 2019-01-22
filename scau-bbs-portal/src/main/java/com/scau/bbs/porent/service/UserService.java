package com.scau.bbs.porent.service;

import com.scau.bbs.porent.entity.User;

/** @Author  xhh Create By 2017/8/24 */
public interface UserService {

  User getUserByApi(String token);
}
