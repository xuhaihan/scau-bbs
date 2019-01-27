package com.scau.bbs.porent.controller;


import com.scau.bbs.common.feign.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rank")
@RestController
public class RankController {
  @Autowired private RestService restService;

  @GetMapping("/topPosts")
  public String getTotPosts() {
    return restService.getTotPosts();
  }

  @GetMapping("/newUsers")
  public String getNewUser() {
    return restService.getNewUser();
  }
}
