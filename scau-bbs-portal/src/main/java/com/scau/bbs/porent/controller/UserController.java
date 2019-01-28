package com.scau.bbs.porent.controller;

import com.scau.bbs.common.feign.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/** @Author xhh Create By 2019/1/15 */
@RequestMapping("/user")
@Controller
public class UserController {

  @Autowired private RestService restService;

  @RequestMapping("/login")
  public String login() {
    return "user/login";
  }

  @RequestMapping("/register")
  public String register() {
    return "user/register";
  }

  @RequestMapping("/home")
  public String home() {
    return "user/home";
  }

  @RequestMapping("/pages/set")
  public String setting() {
    return "user/set";
  }

  @RequestMapping("/pages/seticon")
  public String seticon() {
    return "user/seticon";
  }

  @RequestMapping("/pages/setpsw")
  public String setpsw() {
    return "user/setpsw";
  }

  @RequestMapping("/pages/message")
  public String message() {
    return "user/message";
  }

  @PostMapping
  @ResponseBody
  public String checkUserName(
      @RequestParam("email") String email,
      @RequestParam("username") String username,
      @RequestParam("password") String password) {
    return restService.checkUserName(email, username, password);
  }

  @PostMapping("/login")
  @ResponseBody
  public String login(
      @RequestParam("email") String email, @RequestParam("password") String password) {
    return restService.login(email, password);
  }

  @GetMapping("/{token}")
  @ResponseBody
  public String getUserByToken(@PathVariable(value = "token") String token) {
    return restService.getUserByToken(token);
  }

  @GetMapping("/message/{token}")
  @ResponseBody
  public String getUserAndMessageByToken(@PathVariable(value = "token") String token) {
    return restService.getUserAndMessageByToken(token);
  }

  @PutMapping("/{token}")
  @ResponseBody
  public String updateUser(
      @PathVariable("token") String token,
      @RequestParam("username") String username,
      @RequestParam("signature") String signature,
      @RequestParam("sex") Integer sex) {
    return restService.updateUser(token, username, signature, sex);
  }

  @PutMapping("/password/{token}")
  @ResponseBody
  public String updatePassword(
      @PathVariable("token") String token,
      @RequestParam("newpsd") String newpsd,
      @RequestParam("oldpsd") String oldpsd) {
    return restService.updatePassword(token, newpsd, oldpsd);
  }

  @PostMapping("/pages/logout")
  @ResponseBody
  public String logout(@RequestParam("token") String token) {
    return restService.logout(token);
  }

  @GetMapping("/detail/{userid}")
  @ResponseBody
  public String getUserById(@PathVariable("userid") Integer userid) {
    return restService.getUserById(userid);
  }
}
