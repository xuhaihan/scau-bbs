package com.scau.bbs.admin.service;

import com.scau.bbs.common.base.BaseService;
import com.scau.bbs.common.entity.User;
import org.springframework.data.domain.Page;

/**
 * @Author xhh
 * Created by xhh on 2019/1/14.
 */
public interface UserService  extends BaseService<User> {

    /**
     * 翻页获取用户列表
     * @param user
     * @param pageNo
     * @param length
     * @return
     */
    Page<User> findByPage(User user, int pageNo, int length);

    /**
     * 恢复/封禁用户
     * @param id
     */
    void saveUserEnable(Integer[] id);
}
