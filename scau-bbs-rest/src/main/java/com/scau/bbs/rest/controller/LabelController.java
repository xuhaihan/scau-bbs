package com.scau.bbs.rest.controller;

import com.scau.bbs.common.base.BaseController;
import com.scau.bbs.common.dto.QuarkResult;
import com.scau.bbs.common.entity.Label;
import com.scau.bbs.rest.service.LabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** @Author xhh Create By 2019/1/16 */
@Api(value = "标签接口", description = "获取标签")
@RestController
@RequestMapping("/label")
public class LabelController extends BaseController {

  @Autowired private LabelService labelService;

  @ApiOperation("获取标签")
  @GetMapping
  public QuarkResult getAllLabel() {

    QuarkResult result =
        restProcessor(
            () -> {
              List<Label> labels = labelService.findAll();
              return QuarkResult.ok(labels);
            });

    return result;
  }
}
