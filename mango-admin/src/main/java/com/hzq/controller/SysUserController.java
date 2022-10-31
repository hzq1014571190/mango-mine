package com.hzq.controller;

import com.hzq.domain.SysUser;
import com.hzq.dto.ResultBean;
import com.hzq.page.PageResult;
import com.hzq.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.io.File;

/**
 * @Author hzq
 * @ClassName SysUserController
 * @Date 2022/10/27 12:00
 * @Description 用户controller
 */
@Api(value = "/user", tags = {"用户controller"})
@RestController
@RequestMapping("/user")
public class SysUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageIndex", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "页面显示数", required = true)
    })
    @ApiOperation(value = "分页查询", notes = "分页查询用户", httpMethod = "GET")
    @GetMapping("/all")
    public ResultBean<PageResult<SysUser>> finaByPage(@RequestParam("pageIndex") Integer pageIndex, @RequestParam("pageSize") Integer pageSize){
        return new ResultBean<>(sysUserService.findByPage(pageIndex, pageSize));
    }


    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageIndex", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "页面显示数", required = true)
    })
    @ApiOperation(value = "导出excel", notes = "将当前页用户导出为excel报表", httpMethod = "GET")
    @GetMapping("/export/excel")
    public ResultBean<File> exportUserExcelFile(@RequestParam("pageIndex") Integer pageIndex, @RequestParam("pageSize") Integer pageSize){
        return new ResultBean<>(sysUserService.createUserExcelFile(pageIndex, pageSize));
    }

}
