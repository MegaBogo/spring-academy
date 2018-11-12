package com.newlecture.web.academy.dao;

import java.util.List;

import com.newlecture.web.academy.entity.Academy;

public interface AcademyDao {
	int insert(Academy academy);
	int update(Academy academy);
	int delete(String id);
	int deleteList(String[] ids);
	
	Academy get(String id);
	List<Academy> getList();
}
