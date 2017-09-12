package cn.bdqn.util;

import java.util.List;

import cn.bdqn.entity.Book;

public class PageSupport {
	private int totalPageCount=1;//总页数
	private int pageSize=0;//每页显示多少条数据
	private int totalCount;//总记录数
	private int currPageNo=1;//当前页
	List<Book> newsList;
	
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize>0)
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if(totalCount>0)
		this.totalCount = totalCount;
		totalPageCount=this.totalCount%pageSize==0?
				(this.totalCount/pageSize):this.totalCount/pageSize+1;
	}
	public int getCurrPageNo() {
		if(totalPageCount==0)
			return 0;
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		if(this.currPageNo>0)
		this.currPageNo = currPageNo;
	}
	public List<Book> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<Book> newsList) {
		this.newsList = newsList;
	}
	
	
}	
