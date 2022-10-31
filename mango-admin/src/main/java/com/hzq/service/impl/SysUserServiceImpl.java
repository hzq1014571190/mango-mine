package com.hzq.service.impl;

import com.hzq.common.utils.DateTimeUtils;
import com.hzq.common.utils.PoiUtils;
import com.hzq.domain.SysDept;
import com.hzq.domain.SysRole;
import com.hzq.domain.SysUserRole;
import com.hzq.mapper.*;
import com.hzq.page.MybatisPageHelper;
import com.hzq.page.PageResult;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hzq.domain.SysUser;
import com.hzq.service.SysUserService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult<SysUser> findByPage(Integer pageIndex, Integer pageSize) {
        PageResult<SysUser> page = MybatisPageHelper.findPage(pageIndex, pageSize, () -> sysUserMapper.findAll());
        return page;
    }

    @Override
    public File createUserExcelFile(Integer pageIndex, Integer pageSize) {
        // 拿到当前页的数据
        PageResult<SysUser> pageResult = findByPage(pageIndex, pageSize);
        return createUserExcelFile(pageResult.getContent());
    }

    public File createUserExcelFile(List<SysUser> records) {
        if (records == null) {
            records = new ArrayList<>();
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row0 = sheet.createRow(0);
        int columnIndex = 0;
        row0.createCell(columnIndex).setCellValue("No");
        row0.createCell(++columnIndex).setCellValue("ID");
        row0.createCell(++columnIndex).setCellValue("用户名");
        row0.createCell(++columnIndex).setCellValue("昵称");
        row0.createCell(++columnIndex).setCellValue("机构");
        row0.createCell(++columnIndex).setCellValue("角色");
        row0.createCell(++columnIndex).setCellValue("邮箱");
        row0.createCell(++columnIndex).setCellValue("手机号");
        row0.createCell(++columnIndex).setCellValue("状态");
        row0.createCell(++columnIndex).setCellValue("头像");
        row0.createCell(++columnIndex).setCellValue("创建人");
        row0.createCell(++columnIndex).setCellValue("创建时间");
        row0.createCell(++columnIndex).setCellValue("最后更新人");
        row0.createCell(++columnIndex).setCellValue("最后更新时间");

        // 查出集团的所有公司和部门
        List<SysDept> sysDepts = sysDeptMapper.selectAll();

        Map<Long, String> collect = sysDepts.stream().collect(Collectors.toMap(SysDept::getId, SysDept::getName));
        Map<Long, SysDept> data = sysDepts.stream().collect(Collectors.toMap(SysDept :: getId, sysDept -> sysDept));
        for (SysDept sysDept : sysDepts) {
            SysDept temp = sysDept;
            StringBuilder sb = new StringBuilder(data.get(temp.getId()).getName());
            while (temp.getParentId() != null){
                sb.insert(0, data.get(temp.getParentId()).getName() + " ");
                temp = data.get(temp.getParentId());
            }
            collect.put(sysDept.getId(), sb.toString());
        }


        // 查出角色对应的角色的总集合 以userId为key
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectAll();
        Map<Long, Long> userToRole = sysUserRoles.stream().collect(Collectors.toMap(SysUserRole::getUserId, SysUserRole::getRoleId));
        List<SysRole> sysRoles = sysRoleMapper.selectAll();
        Map<Long, String> roleToName = sysRoles.stream().collect(Collectors.toMap(SysRole::getId, SysRole::getRemark));


        for (int i = 0; i < records.size(); i++) {
            SysUser user = records.get(i);
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < columnIndex + 1; j++) {
                row.createCell(j);
            }
            columnIndex = 0;
            row.getCell(columnIndex).setCellValue(i + 1);
            row.getCell(++columnIndex).setCellValue(user.getId());
            row.getCell(++columnIndex).setCellValue(user.getName());
            row.getCell(++columnIndex).setCellValue(user.getNickName());
            // 机构名称
            row.getCell(++columnIndex).setCellValue(collect.get(user.getDeptId()));
            // 角色名称
            row.getCell(++columnIndex).setCellValue(roleToName.get(userToRole.get(user.getId())));
            row.getCell(++columnIndex).setCellValue(user.getEmail());
            row.getCell(++columnIndex).setCellValue(user.getMobile());
            row.getCell(++columnIndex).setCellValue(user.getStatus());

            row.getCell(++columnIndex).setCellValue(user.getAvatar());

            row.getCell(++columnIndex).setCellValue(user.getCreateBy());

            row.getCell(++columnIndex).setCellValue(DateTimeUtils.getDateTime(user.getCreateTime()));

            row.getCell(++columnIndex).setCellValue(user.getLastUpdateBy());

            row.getCell(++columnIndex).setCellValue(DateTimeUtils.getDateTime(user.getLastUpdateTime()));
        }
        return PoiUtils.createExcelFile(workbook, "download_user");
    }

}
