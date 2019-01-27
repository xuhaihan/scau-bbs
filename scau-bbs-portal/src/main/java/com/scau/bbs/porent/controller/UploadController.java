package com.scau.bbs.porent.controller;


import com.scau.bbs.common.feign.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.annotation.MultipartConfig;

@RequestMapping("/upload")
@RestController
@MultipartConfig
public class UploadController {
  @Autowired private RestService restService;

  @PostMapping("/image")
  public String upload(MultipartFile file) {
    return restService.upload(file);
  }

  @PostMapping(value = "/usericon/{token}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public String iconUpload(
          @RequestPart(value = "file") MultipartFile file,@PathVariable(value = "token") String token) {
    return restService.iconUpload(file,token);
  }
}
