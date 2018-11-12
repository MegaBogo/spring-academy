package com.newlecture.web.academy.config;

import javax.servlet.Filter;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherSerlvetInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		System.out.println("ㅠㅠㅠ");
		
		return new Class[] { 
				ServletContextConfig.class,
				ServiceContextConfig.class,
				SecurityContextConfig.class
		};
	}

	
	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}
	
	 @Override
     protected Filter[] getServletFilters() {

       CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
       characterEncodingFilter.setEncoding("UTF-8");
       characterEncodingFilter.setForceEncoding(true); //강제로 설정
       
       return new Filter[] { 
    		   characterEncodingFilter 
       };
     }
	 
}
