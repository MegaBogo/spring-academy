package com.newlecture.web.academy.dao.hb;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.academy.dao.MainMenuDao;
import com.newlecture.web.academy.entity.MainMenu;

@Repository
public class HbMainMenuDao implements MainMenuDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public int insert(MainMenu mainMenu) {
		Session session = sessionFactory.getCurrentSession();
	
		Object id = session.save(mainMenu);
		if(id != null)
			return 1;
		
		return 0;
	}

	@Override
	@Transactional
	public int update(MainMenu mainMenu) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(mainMenu);
		
		return 1;
	}

	@Override
	@Transactional
	public MainMenu get(int id) {
		Session session = sessionFactory.getCurrentSession();
		MainMenu mainMenu = session.get(MainMenu.class, id);
		return mainMenu;
	}

	@Override
	@Transactional
	public List<MainMenu> getList() {
		//https://docs.jboss.org/hibernate/orm/3.3/reference/ko-KR/html/queryhql.html
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from MainMenu";
		
		List<MainMenu> list = session
								.createQuery(hql, MainMenu.class)
								.getResultList();
		
		return list;
	}
	
	@Override
	@Transactional
	public int delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		//Membmer member = session.get(Member.class, id);
		MainMenu mainMenu = new MainMenu();
		mainMenu.setId(id);
		
		session.remove(mainMenu);
		return 0;
	}	

	@Override
	@Transactional
	public int deleteList(Integer[] menuIds) {
		
		for(int id : menuIds)
			System.out.println(id);
		
		
		Session session = sessionFactory.getCurrentSession();
		
		String sql = "delete from MainMenu where id in(:ids)";
		Query query = session.createQuery(sql)
				.setParameterList ("ids", menuIds);
		
		int result = query.executeUpdate();
		
		return result;
	}

	@Override
	@Transactional
	public List<MainMenu> getListByAcademyId(String academyId) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from MainMenu where academyId =:academyId";
		
		List<MainMenu> list = session
								.createQuery(hql, MainMenu.class)
								.setParameter("academyId", academyId)
								.getResultList();
		
		return list;
	}
}
