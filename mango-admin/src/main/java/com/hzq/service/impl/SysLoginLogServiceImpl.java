package com.hzq.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hzq.mapper.SysLoginLogMapper;
import com.hzq.domain.SysLoginLog;
import com.hzq.service.SysLoginLogService;
@Service
public class SysLoginLogServiceImpl implements SysLoginLogService{

    @Resource
    private SysLoginLogMapper sysLoginLogMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysLoginLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysLoginLog record) {
        return sysLoginLogMapper.insert(record);
    }

    @Override
    public int insertSelective(SysLoginLog record) {
        return sysLoginLogMapper.insertSelective(record);
    }

    @Override
    public SysLoginLog selectByPrimaryKey(Long id) {
        return sysLoginLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysLoginLog record) {
        return sysLoginLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysLoginLog record) {
        return sysLoginLogMapper.updateByPrimaryKey(record);
    }

}
