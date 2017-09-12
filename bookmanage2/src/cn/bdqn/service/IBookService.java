package cn.bdqn.service;

import java.util.List;

import cn.bdqn.entity.Book;

public interface IBookService {
public List<Book> getAll();
public boolean add(Book book);
public boolean delete(Book book);
public boolean update(Book book);
public Book getBookBy(Book book);
public List<Book> find(int page,int size);
public int count();
}
