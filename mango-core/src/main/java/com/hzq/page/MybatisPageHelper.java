package com.hzq.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import java.util.List;
import java.util.function.Supplier;

/**
 * MyBatis 分页查询助手
 * @author Louis
 * @date Jan 12, 2019
 */
public class MybatisPageHelper {


	public static <T> PageResult<T> findPage(Integer pageIndex, Integer pageSize, Supplier<List<T>> supplier) {
		PageHelper.startPage(pageIndex, pageSize);
		List<T> list = supplier.get();
		PageInfo<T> pageInfo = new PageInfo<>(list);
		return new PageResult<>(pageIndex, pageSize, pageInfo.getTotal(), pageInfo.getPages(), list);
	}


}
