package com.scau.bbs.common.dao;

import com.scau.bbs.common.entity.Reply;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author xhh
 * Created by xhh on 2019/1/11
 */
@CacheConfig(cacheNames = "replies")
@Repository
public interface ReplyDao extends JpaRepository<Reply,Integer>,JpaSpecificationExecutor {

    @Cacheable
    List<Reply> findAll();
}
