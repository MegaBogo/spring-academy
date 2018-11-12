package com.newlecture.web.academy.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.academy.dao.AcademyDao;
import com.newlecture.web.academy.dao.MainMenuDao;
import com.newlecture.web.academy.entity.Academy;
import com.newlecture.web.academy.entity.MainMenu;
import com.newlecture.web.academy.service.MemberService;
import com.newlecture.web.academy.service.UIService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	//컨트롤러에서 다오를 직접 쓰는 일은 없어야함!!!
	/*
	@Autowired
	private AcademyDao academyDao;
	
	@Autowired
	private MainMenuDao mainMenuDao;
	*/
	
	@Autowired
	private UIService uiService;
	
	@Autowired
	private MemberService memberService; //아카데미, 공지사항, 회원, 강 ...
	//키서비스, 구성요소 서비스, 고나리자, 콤포넌트,..... 그룹명을 정해주세요
	
	
	
	// /academy/{id} --> /academy/sist
	@GetMapping("{id}")
	public String index(@PathVariable("id") String id, Model model) {
		
		Academy academy = memberService.getAcademy(id);
		model.addAttribute("academy", academy);
		
		return "home.index";
		
    }
	
	@GetMapping("upload-ajax")
	@ResponseBody
	public String uploadAjax() {
		return "test";
	}
	
	@PostMapping("upload-ajax")
	@ResponseBody
	public void uploadAjax(MultipartFile file, HttpServletRequest request) {
		//멤버에 대한 정보
		//String memberId = principal.getName();
		//String academyId = service.getAcademyIdByMemberId();
		String academyId = "sist";
		
		// academy/resources/parthers/sist/
		String urlPath = "/resources/partners/"+academyId;
		
		ServletContext context = request.getServletContext();
		String realPath = context.getRealPath(urlPath);
		String uploadedFileName = file.getOriginalFilename();
		
		String filePath = realPath + uploadedFileName;
		
		System.out.println(filePath);
		
		File uploadedFile = new File(realPath);
		
		if(!uploadedFile.exists())
			uploadedFile.mkdirs();		
		
		InputStream fis;
		try {
			fis = file.getInputStream();
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size = 0;
	        while((size = fis.read(buf,0,buf.length)) > 0)
	            fos.write(buf,0,size);
	        
	        fis.close();
	        fos.close();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	 
	
}
