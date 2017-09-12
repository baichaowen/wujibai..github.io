package cn.bdqn.service;

import java.util.List;

import cn.bdqn.entity.Bookuser;

public interface IBookUserService {
	public boolean login(Bookuser bookuser);
	public List<Bookuser> getAll();
	public Bookuser getObjectBy(Bookuser t);
}
