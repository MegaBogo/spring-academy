package com.newlecture.web.academy.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.academy.dao.MemberRoleDao;
import com.newlecture.web.academy.entity.MemberRole;

@Repository
public class HbMemberRoleDao implements MemberRoleDao {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<MemberRole> getListByMemberId(String memberId) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from MemberRole where memberId =:memberId";
		
		List<MemberRole> list = session
								.createQuery(hql, MemberRole.class)
								.setParameter("memberId", memberId)
								.getResultList();
		
		return list;
	}

}
