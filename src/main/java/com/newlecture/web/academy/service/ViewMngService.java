package com.newlecture.web.academy.service;

import java.util.List;
import com.newlecture.web.academy.entity.MainMenu;

public interface ViewMngService {
	List<MainMenu> getMainMenuList();
	int addMainMenu(MainMenu mainMenu);
	MainMenu getMainMenu(int id);
	int updateMainMenu(MainMenu mainMenu);
	int deleteMainMenu(int menuId);
	int deleteMainMenuList(Integer[] menuIds);
}

