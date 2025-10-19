package com.utils;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan(basePackages = "com")
@Configuration
@EnableWebMvc
@EnableTransactionManagement
public class Config {
	
////	This is for Dispatcher Servlet 
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
	
	
	@Bean
	public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");  
	    dataSource.setUrl("jdbc:mysql://localhost:3306/projects");
	    dataSource.setUsername("root");
	    dataSource.setPassword("Sajja@123");
	    return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean=new  LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan("com");
		localSessionFactoryBean.setHibernateProperties(hibernateProperty());
		return localSessionFactoryBean;
	}
	
	public Properties hibernateProperty() {
		Properties prop=new Properties();
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		prop.put("hibernate.hbm2ddl.auto", "update");
		return prop;
		
	}
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessonFactory) {
////		oka bean object(sessonFactory) ni parameter ga oka method lo pass cheste auttomatically value is injected to  it
		HibernateTransactionManager tmanager = new HibernateTransactionManager();
		 tmanager.setSessionFactory(sessonFactory);
		 return tmanager;
	}
	
}
