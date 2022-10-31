package com.hzq.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hzq.mapper.SysLogMapper;
import com.hzq.domain.SysLog;
import com.hzq.service.SysLogService;
@Service
public class SysLogServiceImpl implements SysLogService{

    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysLog record) {
        return sysLogMapper.insert(record);
    }

    @Override
    public int insertSelective(SysLog record) {
        return sysLogMapper.insertSelective(record);
    }

    @Override
    public SysLog selectByPrimaryKey(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysLog record) {
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysLog record) {
        return sysLogMapper.updateByPrimaryKey(record);
    }

}
