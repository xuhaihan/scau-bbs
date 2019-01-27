package com.scau.bbs.porent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** @Author xhh Create By 2019/1/15 */
@Controller
@RequestMapping("/pages")
public class PageController {

  @RequestMapping("/index")
  public String indexPage() {
    return "index";
  }

  @RequestMapping("/label")
  public String labelHome() {
    return "label/home";
  }

  @RequestMapping("/chat")
  public String chatHome() {
    return "chat/home";
  }
}
