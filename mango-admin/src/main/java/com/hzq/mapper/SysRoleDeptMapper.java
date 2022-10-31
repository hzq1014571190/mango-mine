package com.hzq.mapper;

import com.hzq.domain.SysRoleDept;

public interface SysRoleDeptMapper {
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
    int insert(SysRoleDept record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(SysRoleDept record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    SysRoleDept selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SysRoleDept record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SysRoleDept record);
}