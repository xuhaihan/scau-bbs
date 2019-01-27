package com.scau.bbs.common.feign;


import com.scau.bbs.common.config.FeignMultipartSupportConfig;
import com.scau.bbs.common.entity.Reply;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "scau-bbs-rest",configuration = FeignMultipartSupportConfig.class)
public interface RestService {

  @RequestMapping("/label")
  String getAllLabel();

  @GetMapping("/notification/{uid}")
  String getAllNotification(@PathVariable(value = "uid") Integer uid);

  @DeleteMapping("/notification/{uid}")
  String deleteAllNotification(@PathVariable(value = "uid") Integer uid);

  @PostMapping("/posts")
  String CreatePosts(
      @RequestParam(value = "title", required = true) String title,
      @RequestParam(value = "content", required = true) String content,
      @RequestParam(value = "token", required = true) String token,
      @RequestParam(value = "labelId", required = true) Integer labelId);

  @GetMapping("/posts")
  String GetPosts(
      @RequestParam(value = "search", required = false, defaultValue = "") String search,
      @RequestParam(value = "type", required = false, defaultValue = "") String type,
      @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
      @RequestParam(value = "length", required = false, defaultValue = "20") int length);

  @GetMapping("/posts/detail/{postsid}")
  String GetPostsDetail(
      @PathVariable(value = "postsid") Integer postsid,
      @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
      @RequestParam(value = "length", required = false, defaultValue = "20") int length);

  @GetMapping("/posts/label/{labelid}")
  String GetPostsByLabel(
      @PathVariable(value = "labelid") Integer labelid,
      @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo,
      @RequestParam(value = "length", required = false, defaultValue = "20") int length);

  @GetMapping("/rank/topPosts")
  String getTotPosts();

  @GetMapping("/rank/newUsers")
  String getNewUser();

  @PostMapping("/reply")
  String CreateReply(
      @RequestParam(value="content",required = true) String content,
      @RequestParam(value = "postsId", required = true) Integer postsId,
      @RequestParam(value = "token", required = true) String token);

  @PostMapping("/upload/image")
  String upload(@RequestParam(value = "file") MultipartFile file);

  @PostMapping(value = "/upload/usericon/{token}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  String iconUpload(@RequestPart(value = "file") MultipartFile file,@PathVariable(value = "token") String token);

  @PostMapping("/user")
  String checkUserName(
      @RequestParam(value = "email", required = true) String email,
      @RequestParam(value = "username", required = true) String username,
      @RequestParam(value = "password", required = true) String password);

  @PostMapping("/user/login")
  String login(
      @RequestParam(value = "email", required = true) String email,
      @RequestParam(value = "password", required = true) String password);

  @GetMapping("/user/{token}")
  String getUserByToken(@PathVariable(value = "token") String token);

  @GetMapping("/user/message/{token}")
  String getUserAndMessageByToken(@PathVariable(value = "token") String token);

  @PutMapping("/user/{token}")
  String updateUser(
      @PathVariable(value = "token") String token,
      @RequestParam(value = "username", required = true) String username,
      @RequestParam(value = "signature", required = true) String signature,
      @RequestParam(value = "sex", required = true) Integer sex);

  @PutMapping("/user/password/{token}")
  String updatePassword(
      @PathVariable(value = "token", required = true) String token,
      @RequestParam(value = "newpsd", required = true) String newpsd,
      @RequestParam(value = "oldpsd", required = true) String oldpsd);

  @PostMapping("/user/logout")
  String logout(String token);

  @GetMapping("/user/detail/{userid}")
  String getUserById(@PathVariable(value = "userid") Integer userid);
}
