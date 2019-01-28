package com.scau.bbs.porent.service.impl;


import com.scau.bbs.common.feign.RestService;
import com.scau.bbs.porent.entity.QuarkResult;
import com.scau.bbs.porent.entity.User;
import com.scau.bbs.porent.service.UserService;
import com.scau.bbs.porent.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/** @Author xhh Create By 2019/1/14 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired private RestService restService;


  @Override
  public User getUserByApi(String token) {
    QuarkResult quarkResult=JsonUtils.jsonToQuarkResult(restService.getUserByToken(token), User.class);
    User data = (User) quarkResult.getData();
    return data;
  }
}
