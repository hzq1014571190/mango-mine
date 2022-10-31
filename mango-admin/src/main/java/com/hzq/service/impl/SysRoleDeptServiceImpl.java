package com.hzq.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hzq.domain.SysRoleDept;
import com.hzq.mapper.SysRoleDeptMapper;
import com.hzq.service.SysRoleDeptService;
@Service
public class SysRoleDeptServiceImpl implements SysRoleDeptService{

    @Resource
    private SysRoleDeptMapper sysRoleDeptMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysRoleDeptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRoleDept record) {
        return sysRoleDeptMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRoleDept record) {
        return sysRoleDeptMapper.insertSelective(record);
    }

    @Override
    public SysRoleDept selectByPrimaryKey(Long id) {
        return sysRoleDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRoleDept record) {
        return sysRoleDeptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRoleDept record) {
        return sysRoleDeptMapper.updateByPrimaryKey(record);
    }

}
