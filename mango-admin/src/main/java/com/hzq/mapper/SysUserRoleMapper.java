package com.hzq.mapper;

import com.hzq.domain.SysUserRole;

import java.util.List;

public interface SysUserRoleMapper {
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
    int insert(SysUserRole record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(SysUserRole record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    SysUserRole selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SysUserRole record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SysUserRole record);

    List<SysUserRole> selectAll();
}