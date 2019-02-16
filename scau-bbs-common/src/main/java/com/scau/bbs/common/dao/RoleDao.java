package com.scau.bbs.common.dao;

import com.scau.bbs.common.entity.Role;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xhh on 2019/1/11
 */

@Repository
@CacheConfig(cacheNames = "roles")
public interface RoleDao extends JpaRepository<Role,Integer>{

    Role findOne(Integer integer);

    @Cacheable
    List<Role> findAll();

}
