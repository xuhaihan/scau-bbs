package com.scau.bbs.admin.service.impl;

import com.scau.bbs.admin.service.ReplyService;
import com.scau.bbs.common.base.BaseServiceImpl;
import com.scau.bbs.common.dao.ReplyDao;
import com.scau.bbs.common.entity.Posts;
import com.scau.bbs.common.entity.Reply;
import com.scau.bbs.common.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;

/**
 * @Author xhh
 * Create By 2019/1/15
 */
@Service
public class ReplyServiceImpl extends BaseServiceImpl<ReplyDao,Reply> implements ReplyService {

    @Override
    public Page<Reply> findByPage(Reply reply, int pageNo, int length) {
        PageRequest pageable = new PageRequest(pageNo, length);

        Specification<Posts> specification = new Specification<Posts>(){

            @Override
            public Predicate toPredicate(Root<Posts> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> $id = root.get("id");
                Path<String> $content = root.get("content");
                Path<User> $user = root.get("user");

                ArrayList<Predicate> list = new ArrayList<>();
                if (reply.getId()!=null) list.add(criteriaBuilder.equal($id,reply.getId()));
                if (reply.getContent()!=null) list.add(criteriaBuilder.like($content,"%" + reply.getContent() + "%"));
                if (reply.getUser()!=null) list.add(criteriaBuilder.equal($user,reply.getUser()));

                Predicate predicate = criteriaBuilder.and(list.toArray(new Predicate[list.size()]));

                return predicate;
            }
        };
        Page<Reply> page = repository.findAll(specification, pageable);
        return page;
    }
}
