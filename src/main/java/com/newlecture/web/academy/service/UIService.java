package com.newlecture.web.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.academy.dao.AcademyDao;
import com.newlecture.web.academy.dao.MainMenuDao;

@Service
public class UIService {
	
	@Autowired
	private AcademyDao academyDao;
	
	@Autowired
	private MainMenuDao mainMenuDao;
	
}
