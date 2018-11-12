package com.newlecture.web.academy.dao;

import java.util.List;

import com.newlecture.web.academy.entity.MainMenu;

public interface MainMenuDao {
	int insert(MainMenu mainMenu);
	int update(MainMenu mainMenu);
	int delete(int id);
	int deleteList(Integer[] menuIds);
	
	MainMenu get(int id);
	List<MainMenu> getList(); 
	List<MainMenu> getListByAcademyId(String id);
}
