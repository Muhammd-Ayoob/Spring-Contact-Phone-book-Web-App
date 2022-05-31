/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapp.config;

import com.webapp.dao.ContactDAOImpl;
import com.webapp.dao.UserDAO;
import com.webapp.dao.UserDAOImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Muhammad Ayoob Bugti
 */

@Configuration
@ComponentScan(basePackages = {"com.webapp.dao"})
public class SpringRootConfig {
    
    @Bean("dataSource")
    public BasicDataSource getDataSource(){
        
        BasicDataSource dataSource= new BasicDataSource();
        
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        
        dataSource.setUrl("jdbc:mysql://localhost:3306/contact_app");
        
        dataSource.setUsername("root");
        
        dataSource.setPassword("admin");
        return dataSource;
        
    }
	
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate()
	{
		
		JdbcTemplate jdbcTemplate= new JdbcTemplate();
		
		jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate;
	}
	
	
	@Bean(name = "userDao")
	public UserDAOImpl getDaoImpl()
	{
		UserDAOImpl daoImpl= new UserDAOImpl();
		
		daoImpl.setJdbcTemplate(getJdbcTemplate());
		
		return daoImpl;
	}
    
        
        @Bean(name = "contactDao")
	public ContactDAOImpl getContactDaoImpl()
	{
		ContactDAOImpl daoImpl= new ContactDAOImpl();
		
		daoImpl.setJdbcTemplate(getJdbcTemplate());
		
		return daoImpl;
	}
}
