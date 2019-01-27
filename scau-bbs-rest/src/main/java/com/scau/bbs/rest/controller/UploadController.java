package com.scau.bbs.rest.controller;

import com.scau.bbs.common.dto.UploadResult;
import com.scau.bbs.common.exception.ServiceProcessException;
import com.scau.bbs.rest.service.UserService;
import com.scau.bbs.rest.utils.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;

/** @Author xhh Create By 2019/1/16 */
@Api(value = "文件上传接口", description = "图片上传")
@RestController
@RequestMapping("/upload")
@MultipartConfig
public class UploadController {

  @Autowired private UserService userService;

  @ApiOperation("图片上传接口")
  @PostMapping("/image")
  public UploadResult upload(@RequestPart("file") MultipartFile file) {
    UploadResult result = null;
    if (!file.isEmpty()) {
      try {
        String s = FileUtils.uploadFile(file);
        result = new UploadResult(0, new UploadResult.Data(s));
        return result;
      } catch (IOException e) {
        e.printStackTrace();
        result = new UploadResult(1, "上传图片失败");
      }
      return result;
    }
    result = new UploadResult(1, "文件不存在");
    return result;
  }

  @ApiOperation("用户头像上传接口")
  @PostMapping("/usericon/{token}")
  public UploadResult iconUpload(
      @RequestPart("file") MultipartFile file, @PathVariable("token") String token) {
    UploadResult result = null;
    if (!file.isEmpty()) {
      try {
        String icon = FileUtils.uploadFile(file);
        userService.updataUserIcon(token, icon);
        return new UploadResult(0, new UploadResult.Data(icon));
      } catch (IOException e) {
        e.printStackTrace();
        return new UploadResult(1, "上传图片失败");
      } catch (ServiceProcessException e1) {
        e1.printStackTrace();
        return new UploadResult(1, e1.getMessage());
      }
    }
    return new UploadResult(1, "文件不存在");
  }
}
