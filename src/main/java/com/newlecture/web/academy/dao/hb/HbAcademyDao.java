package com.newlecture.web.academy.dao.hb;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.academy.dao.AcademyDao;
import com.newlecture.web.academy.entity.Academy;

@Repository
public class HbAcademyDao implements AcademyDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public int insert(Academy academy) {
		Session session = sessionFactory.getCurrentSession();
		
		Object id = session.save(academy);
		if(id != null)
			return 1;
		
		return 0;
	}

	@Override
	@Transactional
	public int update(Academy academy) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(academy);
		
		return 1;
	}

	@Override
	@Transactional
	public int delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		
		//Membmer member = session.get(Member.class, id);
		Academy academy = new Academy();
		academy.setId(id);
		
		session.remove(academy);
		return 0;
	}

	@Override
	@Transactional
	public int deleteList(String[] ids) {
		for(String id : ids)
			System.out.println(id);
		
		
		Session session = sessionFactory.getCurrentSession();
		
		String sql = "delete from MainMenu where id in(:ids)";
		Query query = session.createQuery(sql)
				.setParameterList ("ids", ids);
		
		int result = query.executeUpdate();
		
		return result;
	}

	@Override
	@Transactional
	public Academy get(String id) {
		Session session = sessionFactory.getCurrentSession();
		Academy academy = session.get(Academy.class, id);
		return academy;
	}

	@Override
	@Transactional
	public List<Academy> getList() {
		//https://docs.jboss.org/hibernate/orm/3.3/reference/ko-KR/html/queryhql.html
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from MainMenu";
		
		List<Academy> list = session
								.createQuery(hql, Academy.class)
								.getResultList();
		
		return list;
	}

}
