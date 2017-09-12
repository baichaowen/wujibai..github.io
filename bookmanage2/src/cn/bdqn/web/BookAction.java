package cn.bdqn.web;

import java.util.List;

import cn.bdqn.entity.Book;
import cn.bdqn.service.IBookService;
import cn.bdqn.util.PageSupport;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Book book;
	private PageSupport pageSupport;
	private int pageSize;
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

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	private int totalCount;
	private int currPageNo;
	private int totalPageCount;
	public PageSupport getPageSupport() {
		return pageSupport;
	}

	public void setPageSupport(PageSupport pageSupport) {
		this.pageSupport = pageSupport;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public IBookService getBookservice() {
		return bookservice;
	}

	public void setBookservice(IBookService bookservice) {
		this.bookservice = bookservice;
	}

	private IBookService bookservice;
	private List<Book> list;
	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public String list() throws Exception {
		/*list=bookservice.getAll();*/
		if(currPageNo==0){
			currPageNo=1;		
		}		
	int a=bookservice.count();
	if(pageSize==0){
		
		pageSize=2;
	}
	pageSupport=new PageSupport();
	
	pageSupport.setPageSize(pageSize);
	pageSupport.setTotalCount(a);
	
	pageSupport.setCurrPageNo(currPageNo);
	list=bookservice.find(currPageNo, pageSupport.getPageSize());
	System.out.println(a);
		String isList="input";
		if(list.size()>0){
			isList="success";
			
		}
		return isList;
	}
	public String add() throws Exception{
		String isadd="input";
		if(bookservice.add(book)){
			/*list=bookservice.getAll();*/
			list();
			isadd="success";
			
		};
		return isadd;
	}
	public String delete() throws Exception{
		String isadd="input";
		if(bookservice.delete(book)){
			/*list=bookservice.getAll();*/
			list();
			isadd="success";
			
		};
		return isadd;
	}
	public String update() throws Exception{
		String isadd="input";
		if(bookservice.update(book)){
			list();
			isadd="success";
			
		};
		return isadd;
	}
	public String preupdate(){
		book=bookservice.getBookBy(book);
		return "pre";
		
	}

}
