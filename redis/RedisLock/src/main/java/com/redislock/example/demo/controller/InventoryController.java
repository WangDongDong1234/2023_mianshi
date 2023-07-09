package com.redislock.example.demo.controller;

import com.redislock.example.demo.service.InventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(tags = "redis分布式锁测试-扣减库存，一次卖一个")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @ApiOperation("版本1（单机）")
    @GetMapping(value = "/inventory/sale1")
    public String sale1(){

        return inventoryService.sale1("001");
    }

    /**
     * 递归是一种思想没错，但是容易导致StackOverflowError，不太推荐，进一步完善
     * @return
     */
    @ApiOperation("版本2（多机）-递归分布式锁实现，容易溢出")
    @GetMapping(value = "/inventory/sale2")
    public String sale2(){

        return inventoryService.sale2("001");
    }



    /**
     * 递归会产生溢出，用while
     * @return
     */
    @ApiOperation("版本3（多机）-while分布式锁实现-解决栈溢出和虚假唤醒-未解决分布式锁过期问题")
    @GetMapping(value = "/inventory/sale3")
    public String sale3(){

        return inventoryService.sale3("001");
    }



    /**
     * 解决分布式锁过期问题
     * @return
     */
    @ApiOperation("版本4（多机）-setnx和expire放到一条命令中去-执行时间大于锁过期时间会产生问题")
    @GetMapping(value = "/inventory/sale4")
    public String sale4(){

        return inventoryService.sale4("001");
    }


    /**
     * 解决删除锁，非原子操作问题
     * @return
     */
    @ApiOperation("版本5（多机）-lua脚本解决删除锁非原子性问题")
    @GetMapping(value = "/inventory/sale5")
    public String sale5(){

        return inventoryService.sale5("001");
    }




}
