package cn.bdqn.dao;

import java.util.List;

public interface IBaseDao<T> {
public List<T> getAll();
public List<T> getByList(T t);
public int add(T t);
public int delete(T t);
public int update(T t);
public T getObjectBy(T t);
public List<T> find(int t,int a);
public int count();
}
