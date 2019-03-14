package com.newlecture.web.academy.config;

import java.util.Properties;

import javax.transaction.TransactionManager;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.newlecture.web.academy.dao.hb", "com.newlecture.web.academy.service"})
public class ServiceContextConfig{

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		/* DB 설정 */
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://*;databaseName=*");
		dataSource.setUsername("*");
		dataSource.setPassword("*");
		
		dataSource.setRemoveAbandoned(true);
		dataSource.setInitialSize(20);
		dataSource.setMaxActive(30);
		
		//dataSource.setRemove
		
		
		
		return dataSource;
	}
	
	//Hibernate 설정을 위한 빈 객체들
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		Properties props = new Properties();
		//props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		props.put("hibernate.show_sql", "true");
	  
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.newlecture.web.academy.entity");
		sessionFactoryBean.setHibernateProperties(props);
	  
		return sessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		
		return transactionManager;
	}
	
	@Bean
	public JavaMailSender mailSender() {
		//사용자 설정 
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setDefaultEncoding("UTF=8");
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("");
		mailSender.setPassword("");
		
		//SMTP 환경 설정
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.smtp.auth", true);
		javaMailProperties.put("mail.smtp.starttls.enable", true);
		javaMailProperties.put("mail.debug", true);
		mailSender.setJavaMailProperties(javaMailProperties);
		
		return mailSender;
	}
	
}
