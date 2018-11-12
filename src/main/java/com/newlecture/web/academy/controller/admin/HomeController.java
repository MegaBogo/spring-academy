package com.newlecture.web.academy.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("AdminHomeController")
@RequestMapping("/sist/admin/")
public class HomeController {
	 @GetMapping("index")
	 public String index() {
		 return "admin.index";
  }
}
