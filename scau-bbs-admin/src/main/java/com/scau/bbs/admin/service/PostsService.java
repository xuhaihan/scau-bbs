package com.scau.bbs.admin.service;

import com.scau.bbs.common.base.BaseService;
import com.scau.bbs.common.entity.Posts;
import org.springframework.data.domain.Page;

/**
 * @Author xhh
 * Created by xhh on 2019/1/14.
 */
public interface PostsService extends BaseService<Posts>{

   /**
    * 翻页条件查询帖子
    * @param posts
    * @param pageNo
    * @param length
    * @return
    */
   Page<Posts> findByPage(Posts posts,int pageNo,int length);

   /**
    * 批量修改帖子的top
    * @param ids
    */
   void changeTop(Integer[] ids);

   /**
    * 批量修改帖子的good
    * @param ids
    */
   void changeGood(Integer[] ids);


}
