package com.scau.bbs.admin.service;

import com.scau.bbs.common.base.BaseService;
import com.scau.bbs.common.entity.Reply;
import org.springframework.data.domain.Page;

/**
 * @Author xhh
 * Created by xhh on 2019/1/14.
 */
public interface ReplyService extends BaseService<Reply>{

    /**
     * 翻页条件查询回复
     * @param reply
     * @param pageNo
     * @param length
     * @return
     */
   Page<Reply> findByPage(Reply reply, int pageNo, int length);

    
}
