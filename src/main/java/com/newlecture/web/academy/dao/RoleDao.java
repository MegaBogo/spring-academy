package com.newlecture.web.academy.dao;

import java.util.List;

import com.newlecture.web.academy.entity.Role;

public interface RoleDao {
	int insert(Role role);
	int update(Role role);
	int delete(String id);
	
	Role get(String id);
	List<Role> getList();
}
