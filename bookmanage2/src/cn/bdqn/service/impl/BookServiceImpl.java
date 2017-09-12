package cn.bdqn.service.impl;

import java.util.List;

import cn.bdqn.dao.IBookDao;
import cn.bdqn.entity.Book;
import cn.bdqn.service.IBookService;

public class BookServiceImpl implements IBookService {
	private IBookDao bookdao;

	public IBookDao getBookdao() {
		return bookdao;
	}

	public void setBookdao(IBookDao bookdao) {
		this.bookdao = bookdao;
	}

	@Override
	public List<Book> getAll() {
		List list=bookdao.getAll();
		
		return list;
	}

	@Override
	public boolean add(Book book) {
		boolean isadd=false;
		if(bookdao.add(book)>0){
			
			isadd=true;
		};
		return isadd;
	}

	@Override
	public boolean delete(Book book) {
		boolean isdelete=false;
		if(bookdao.delete(book)>0){
			
			isdelete=true;
		}
		return isdelete;
	}

	@Override
	public boolean update(Book book) {
		boolean isupdate=false;
		if(bookdao.update(book)>0){
			isupdate=true;
			
		}
		return isupdate;
	}

	@Override
	public Book getBookBy(Book book) {
		
		return bookdao.getObjectBy(book);
	}

	@Override
	public List<Book> find(int page, int size) {
		
		return bookdao.find(page, size);
	}

	@Override
	public int count() {
		
		return bookdao.count();
	}
}
