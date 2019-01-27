package com.scau.bbs.porent.controller;


import com.scau.bbs.common.feign.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** @Author xhh Create By 2019/1/15 */

@Controller
@RequestMapping("/label")
public class LabelController {

  @Autowired private RestService restService;

  @RequestMapping("/detail")
  public String getLabelDetail() {
    return "label/detail";
  }

  @RequestMapping("/list")
  @ResponseBody
  public String getAllLabel() {
    return restService.getAllLabel();
  }
}
