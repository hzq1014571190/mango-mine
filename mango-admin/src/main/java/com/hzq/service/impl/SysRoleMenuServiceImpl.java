package com.hzq.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hzq.domain.SysRoleMenu;
import com.hzq.mapper.SysRoleMenuMapper;
import com.hzq.service.SysRoleMenuService;
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService{

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysRoleMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRoleMenu record) {
        return sysRoleMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRoleMenu record) {
        return sysRoleMenuMapper.insertSelective(record);
    }

    @Override
    public SysRoleMenu selectByPrimaryKey(Long id) {
        return sysRoleMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRoleMenu record) {
        return sysRoleMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRoleMenu record) {
        return sysRoleMenuMapper.updateByPrimaryKey(record);
    }

}
