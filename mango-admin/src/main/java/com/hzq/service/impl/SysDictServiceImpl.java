package com.hzq.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hzq.domain.SysDict;
import com.hzq.mapper.SysDictMapper;
import com.hzq.service.SysDictService;
@Service
public class SysDictServiceImpl implements SysDictService{

    @Resource
    private SysDictMapper sysDictMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysDictMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysDict record) {
        return sysDictMapper.insert(record);
    }

    @Override
    public int insertSelective(SysDict record) {
        return sysDictMapper.insertSelective(record);
    }

    @Override
    public SysDict selectByPrimaryKey(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysDict record) {
        return sysDictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysDict record) {
        return sysDictMapper.updateByPrimaryKey(record);
    }

}
