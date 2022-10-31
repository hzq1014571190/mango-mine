package com.hzq.controller;

import com.hzq.domain.SysUser;
import com.hzq.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hzq
 * @ClassName HelloController
 * @Date 2022/10/26 19:51
 * @Description
 */
@Api("测试Controller")
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "测试方法", notes = "测试一下swagger2", httpMethod = "GET")
    @GetMapping("/test")
    public SysUser test(){
        LOGGER.info("测试方法被执行了");
        return sysUserService.selectByPrimaryKey(1L);
    }
}
