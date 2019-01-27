package com.scau.bbs.porent.controller;

import com.scau.bbs.common.feign.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reply")
public class ReplyController {
  @Autowired private RestService restService;

  @PostMapping("/one")
  public String CreateReply(
      @RequestParam("content") String content,
      @RequestParam("postsId") Integer postsId,
      @RequestParam("token") String token) {
    return restService.CreateReply(content, postsId, token);
  }
}
