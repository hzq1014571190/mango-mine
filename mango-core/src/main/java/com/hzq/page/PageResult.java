package com.hzq.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 分页返回结果
 * @author Louis
 * @date Jan 12, 2019
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageResult<T> {
	/**
	 * 当前页码
	 */
	private int pageNum;
	/**
	 * 每页数量
	 */
	private int pageSize;
	/**
	 * 记录总数
	 */
	private long totalSize;
	/**
	 * 页码总数
	 */
	private int totalPages;
	/**
	 * 分页数据
	 */
	private List<T> content;
}
