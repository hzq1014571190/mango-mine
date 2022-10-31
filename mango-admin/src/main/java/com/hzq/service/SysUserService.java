package com.hzq.service;

import com.hzq.domain.SysUser;
import com.hzq.page.PageResult;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.io.File;
import java.util.List;

public interface SysUserService{


    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    PageResult<SysUser> findByPage(Integer pageIndex, Integer pageSize);


    File createUserExcelFile(Integer pageIndex, Integer pageSize);
}
