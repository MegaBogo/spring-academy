package com.newlecture.web.academy.dao.hb;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Repository;
import com.newlecture.web.academy.dao.MemberDao;
import com.newlecture.web.academy.entity.Member;

@Repository
public class HbMemberDao implements MemberDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Member get(String id) {
		Session session = sessionFactory.getCurrentSession();
		Member member = session.get(Member.class, id);
		
		return member;
	}

}
