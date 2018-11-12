package com.newlecture.web.academy.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.academy.entity.MainMenu;
import com.newlecture.web.academy.service.DefaultViewMngService;

@Controller
@RequestMapping("/sist/admin/view/")
public class ViewController {
	
	@Autowired
	private DefaultViewMngService service;
	
	@GetMapping("header/menu-list")
	public String headerMenuList(
			@RequestParam(name="s", required=false) String selectedMenuId,
			Model model) {
		
		if(selectedMenuId != null) {
			int menuId = Integer.parseInt(selectedMenuId);
			MainMenu selectedMenu = service.getMainMenu(menuId);
			model.addAttribute("selectedMenu", selectedMenu);
		}
			
		
		
		List<MainMenu> menus = service.getMainMenuList();
		model.addAttribute("menus", menus);
		
		return "admin.view.header.menu-list";
	}
	
	@PostMapping("header/menu-list")
	public String headerMenuList(
			MainMenu mainMenu,
			String action,
			@RequestParam(name="selected-menu-id", required=false) Integer selectedMenuId,
			@RequestParam(name="menu-id", required=false) Integer[] menuIds) {
		
		/*
		 * Principal principal : 사용자 정보, 페이지 정보, 등등 보안 관련 등이 담겨져 있음
		 * 
		 * add,reg,insert 등 여러개가 잇는데
		 * 계층별로 맞추는게 더 좋다 
		 * 의인화~ 자연어로!
		 * 그래서 서비스는 add로~
		 */
		
		switch (action) {
			case "일괄삭제":
				//String[] menuIds = request.getParamValues("menu-id");
				//service.removeMenuList(menuIds);
				service.deleteMainMenuList(menuIds);
				break;
			case "삭제":
				service.deleteMainMenu(selectedMenuId);
				break;
			case "저장":
				mainMenu.setId(selectedMenuId);
				service.updateMainMenu(mainMenu);
				break;				
			case "수정":
				return "redirect:menu-list?s="+selectedMenuId;
			case "추가":
				mainMenu.setAcademyId("sist");
				service.addMainMenu(mainMenu);
				break;
		}
		
		return "redirect:menu-list";
	}
	
}
