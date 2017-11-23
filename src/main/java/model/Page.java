package model;

import java.util.List;



public class Page {
	private int minrow;
	private int maxrow;
	// 总页数
	private int pageCount;
	// 页面大小
	private int pageSize;
	// 记录总数
	private int totalCount;
	// 记录总数
	private int total;
	// 页码
	private int pageIndex;
	//某行数
	private int lineNum;
	private List<?> list;

	public int getLineNum() {
		return (pageIndex-1)*pageSize;
	}

	public int getMaxrow() {

		return this.pageIndex * this.pageSize;
	}

	public int getMinrow() {

		return this.getMaxrow() - this.pageSize + 1;
	}
	
	
	public int getPageCount() {
		return this.totalCount % this.pageSize == 0 ? (this.totalCount / this.pageSize)
				: (this.totalCount / this.pageSize + 1);
	}
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
