package com.hzq.mapper;

import com.hzq.domain.SysUser;

import java.util.List;

public interface SysUserMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(SysUser record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(SysUser record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    SysUser selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SysUser record);

    /**
     * 查询所有
     * @return
     */
    List<SysUser> findAll();
}