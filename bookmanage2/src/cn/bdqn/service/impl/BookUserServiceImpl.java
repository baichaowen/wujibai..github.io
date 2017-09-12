package cn.bdqn.service.impl;

import java.util.List;

import cn.bdqn.dao.IBookUserDao;
import cn.bdqn.entity.Bookuser;
import cn.bdqn.service.IBookUserService;

public class BookUserServiceImpl implements IBookUserService {
	private IBookUserDao bookuserdao;
	public IBookUserDao getBookuserdao() {
		return bookuserdao;
	}

	public void setBookuserdao(IBookUserDao bookuserdao) {
		this.bookuserdao = bookuserdao;
	}

	@Override
	public boolean login(Bookuser bookuser) {
		boolean islogin=false;
		if(bookuserdao.getByList(bookuser).size()>0){
			
			islogin=true;
			
		}
		return islogin;
	}

	@Override
	public List<Bookuser> getAll() {
		
		return bookuserdao.getAll();
	}

	@Override
	public Bookuser getObjectBy(Bookuser t) {
		
		return bookuserdao.getObjectBy(t);
	}

}
