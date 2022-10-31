package com.hzq.mapper;

import com.hzq.domain.SysRoleMenu;

public interface SysRoleMenuMapper {
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
    int insert(SysRoleMenu record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(SysRoleMenu record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    SysRoleMenu selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SysRoleMenu record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SysRoleMenu record);
}