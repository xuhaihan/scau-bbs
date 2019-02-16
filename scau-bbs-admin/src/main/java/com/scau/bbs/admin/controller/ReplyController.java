package com.scau.bbs.admin.controller;

import com.scau.bbs.admin.service.ReplyService;
import com.scau.bbs.admin.service.UserService;
import com.scau.bbs.common.base.BaseController;
import com.scau.bbs.common.dto.PageResult;
import com.scau.bbs.common.dto.QuarkResult;
import com.scau.bbs.common.entity.Reply;
import com.scau.bbs.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Author xhh
 * Create By 2017/9/3
 */
@RequestMapping("/replys")
@RestController
public class ReplyController extends BaseController {


    @Autowired
    private UserService userService;

    @Autowired
    private ReplyService replyService;

    @GetMapping
    public PageResult getAll(Reply reply, Integer uid, String draw,
                             @RequestParam(required = false, defaultValue = "1") int start,
                             @RequestParam(required = false, defaultValue = "10") int length) {
        int pageNo = start / length;
        if (uid!=null){
            User user = userService.findOne(uid);
            reply.setUser(user);
        }

        Page<Reply> page = replyService.findByPage(reply, pageNo, length);
        PageResult<List<Reply>> result = new PageResult<>(
                draw,
                page.getTotalElements(),
                page.getTotalElements(),
                page.getContent());
        return result;
    }

    @PostMapping("/delete")
    public QuarkResult delete(@RequestParam(value = "id[]") Reply[] id){
        QuarkResult result = restProcessor(() -> {
            replyService.deleteInBatch(Arrays.asList(id));
            return QuarkResult.ok();
        });
        return result;
    }

}
