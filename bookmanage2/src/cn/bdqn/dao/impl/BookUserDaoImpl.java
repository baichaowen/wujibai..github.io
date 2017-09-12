package cn.bdqn.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.bdqn.dao.IBookUserDao;
import cn.bdqn.entity.Bookuser;

public class BookUserDaoImpl extends HibernateTemplate implements IBookUserDao {
	
	@Override
	public List<Bookuser> getAll() {
		
		return this.getSession().createQuery("from BookUser").list();
	}

	@Override
	public List<Bookuser> getByList(Bookuser t) {
		List<Bookuser> s=findByExample(t);
		System.out.println("值："+s);
		return findByExample(t);
	}

	@Override
	public int add(Bookuser t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Bookuser t) {
	
		return 0;
	}

	@Override
	public int update(Bookuser t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Bookuser getObjectBy(Bookuser t) {
		
		Bookuser b=(Bookuser) this.getSession().createQuery("from Bookuser b where b.name=?").setString(0, t.getName()).list().get(0);
		return b;
	}

	@Override
	public List<Bookuser> find(int t, int a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return  0;
	}

	
}
