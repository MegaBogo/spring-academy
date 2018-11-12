package com.newlecture.web.academy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import com.newlecture.web.academy.dao.MemberDao;
import com.newlecture.web.academy.dao.MemberRoleDao;
import com.newlecture.web.academy.entity.Member;
import com.newlecture.web.academy.entity.MemberRole;

@Service
public class NLUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberRoleDao memberRoleDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member member = memberDao.get(username);
		List<MemberRole> memberRoles = memberRoleDao.getListByMemberId(username);
		
		UserBuilder builder = null;
		String[] authorities = memberRoles
								.stream()
								.map(mr->mr.getRoleName())
								.toArray(String[]::new);
		
		builder = User.withUsername(username);
		builder.password(member.getPwd());
		builder.authorities(authorities);
				
		return builder.build();
	}

}
