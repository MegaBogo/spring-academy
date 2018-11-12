package com.newlecture.web.academy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.academy.dao.MainMenuDao;
import com.newlecture.web.academy.entity.MainMenu;

@Service
public class DefaultViewMngService implements ViewMngService{

	
	@Autowired
	private MainMenuDao mainMenuDao;
	
	@Override
	public List<MainMenu> getMainMenuList() {
		return mainMenuDao.getList();
	}

	@Override
	public int addMainMenu(MainMenu mainMenu) {
		int result = mainMenuDao.insert(mainMenu);
		
		return result;
	}

	@Override
	public MainMenu getMainMenu(int menuId) {
		MainMenu menu = mainMenuDao.get(menuId);
		return menu;
	}

	@Override
	public int updateMainMenu(MainMenu mainMenu) {
		
		MainMenu curMenu = mainMenuDao.get(mainMenu.getId());
		curMenu.setTitle(mainMenu.getTitle());
		curMenu.setUrl(mainMenu.getUrl());
		int result = mainMenuDao.update(curMenu);
		
		return result;
	}
	
	

	@Override
	public int deleteMainMenuList(Integer[] menuIds) {
	
		int result = mainMenuDao.deleteList(menuIds);
		
		return result;
	}

	@Override
	public int deleteMainMenu(int menuId) {
		
		int result = mainMenuDao.delete(menuId);
		return result;
	}
	
}
