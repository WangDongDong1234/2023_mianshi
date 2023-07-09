package com.redislock.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(tags = "测试接口")
public class TestController {

    @ApiOperation("")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void addOrder() {
        log.info("测试接口运行正常");
    }
}