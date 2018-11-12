package com.newlecture.web.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.academy.dao.AcademyDao;
import com.newlecture.web.academy.entity.Academy;

@Service
public class MemberService {

	@Autowired
	private AcademyDao academyDao;
	
	public Academy getAcademy(String id) {
		Academy academy = academyDao.get(id);
		
		//만약 마이바티스를 쓴다면~
		//List<MainMenu> mainMenus = mainMenuDao.getListByAcademyId(academy.getId());
		//academy.setMainMenus(mainMenus);
		
		return academy;
		
	}

}
