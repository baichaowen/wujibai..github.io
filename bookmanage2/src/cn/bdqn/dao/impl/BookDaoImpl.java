package cn.bdqn.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.bdqn.dao.IBookDao;
import cn.bdqn.entity.Book;

public class BookDaoImpl extends HibernateTemplate implements IBookDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAll() {
		
		return this.getSession().createQuery("from Book").list();
	}

	@Override
	public List<Book> getByList(Book t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Book t) {
		Integer bk=(Integer) this.getSession().save(t);
		return bk;
	}

	@Override
	public int delete(Book t) {
		/*Book b=(Book) this.getSession().createQuery("from Book b where b.id="+t.getId()).list().get(0);*/
		Book bk=get(Book.class, t.getId());
		this.getSession().delete(bk);
		return 1;
	}

	@Override
	public int update(Book t) {
		this.getSession().saveOrUpdate(t);
		return 1;
	}

	@Override
	public Book getObjectBy(Book t) {
		
		Book book=this.get(Book.class, t.getId());
		return book;
	}
		/*分页*/
	@Override
	public List<Book> find(final int page,final int size) {
		List result=executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query=session.createQuery("from Book");
				query.setFirstResult((page-1)*size);
				query.setMaxResults(size);
				return query.list();
			}
		});
		return result;
	}
/*
 * 获得总数
 */
	@Override
	public int count() {
			
		String hql = "from Book "; 
		
		return find(hql).size(); 
	}

	
}
