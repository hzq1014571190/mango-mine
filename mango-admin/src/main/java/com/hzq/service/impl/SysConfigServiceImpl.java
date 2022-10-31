package com.hzq.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hzq.domain.SysConfig;
import com.hzq.mapper.SysConfigMapper;
import com.hzq.service.SysConfigService;
@Service
public class SysConfigServiceImpl implements SysConfigService{

    @Resource
    private SysConfigMapper sysConfigMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysConfig record) {
        return sysConfigMapper.insert(record);
    }

    @Override
    public int insertSelective(SysConfig record) {
        return sysConfigMapper.insertSelective(record);
    }

    @Override
    public SysConfig selectByPrimaryKey(Long id) {
        return sysConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysConfig record) {
        return sysConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysConfig record) {
        return sysConfigMapper.updateByPrimaryKey(record);
    }

}
