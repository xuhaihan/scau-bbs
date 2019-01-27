package com.scau.bbs.porent.controller;

import com.scau.bbs.common.feign.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/notification")
@RestController
public class NotificationController {

  @Autowired private RestService restService;

  @GetMapping("/{uid}")
  public String getAllNotification(@PathVariable("uid") Integer uid) {
    return restService.getAllNotification(uid);
  }

  @DeleteMapping("/{uid}")
  public String deleteAllNotification(@PathVariable("uid") Integer uid) {
    return restService.deleteAllNotification(uid);
  }
}
