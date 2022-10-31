package com.hzq.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hzq.domain.SysDept;
import com.hzq.mapper.SysDeptMapper;
import com.hzq.service.SysDeptService;
@Service
public class SysDeptServiceImpl implements SysDeptService{

    @Resource
    private SysDeptMapper sysDeptMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysDeptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysDept record) {
        return sysDeptMapper.insert(record);
    }

    @Override
    public int insertSelective(SysDept record) {
        return sysDeptMapper.insertSelective(record);
    }

    @Override
    public SysDept selectByPrimaryKey(Long id) {
        return sysDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysDept record) {
        return sysDeptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysDept record) {
        return sysDeptMapper.updateByPrimaryKey(record);
    }

}
