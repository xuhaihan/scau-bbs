package com.scau.bbs.porent.controller;

import com.scau.bbs.common.feign.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/** @Author xhh Create By 2019/1/15 */
@Controller
@RequestMapping("/posts")
public class PostsController {

  @Autowired
  private RestService restService;


  @RequestMapping("/pages/add")
  public String add() {
    return "posts/add";
  }

  @RequestMapping("/pages/detail")
  public String detail() {
    return "posts/detail";
  }

  @PostMapping("/one")
  @ResponseBody
  public String CreatePosts(@RequestParam("title") String title,@RequestParam("content") String content, @RequestParam("token") String token, @RequestParam("labelId") Integer labelId) {
    return restService.CreatePosts(title,content,token,labelId);
  }

  @GetMapping("/list")
  @ResponseBody
  public String GetPosts(
      @RequestParam(value = "search", required = false, defaultValue = "") String search,
      @RequestParam(value = "type", required = false, defaultValue = "") String type,
      @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
      @RequestParam(value = "length", required = false, defaultValue = "20") int length) {
    return restService.GetPosts(search, type, pageNo, length);
  }

  @GetMapping("/detail/{postsid}")
  @ResponseBody
  public String GetPostsDetail(
      @PathVariable("postsid") Integer postsid,
      @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
      @RequestParam(value = "length", required = false, defaultValue = "20") int length) {

    return restService.GetPostsDetail(postsid, pageNo, length);
  }

  @GetMapping("/label/{labelid}")
  @ResponseBody
  public String GetPostsByLabel(
      @PathVariable("labelid") Integer labelid,
      @RequestParam(required = false, defaultValue = "1") int pageNo,
      @RequestParam(required = false, defaultValue = "20") int length) {
    return restService.GetPostsByLabel(labelid, pageNo, length);
  }
}
