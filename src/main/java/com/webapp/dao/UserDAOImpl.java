
package com.webapp.dao;

import com.webapp.config.SpringRootConfig;
import com.webapp.model.User;
import com.webapp.rm.UserRowMapperImpl;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muhammad Ayoob Bugti
 */

@Repository
public class UserDAOImpl implements UserDAO{
    

    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate JdbcTemplate) {
        this.jdbcTemplate = JdbcTemplate;
    }
    
    

   
    @Override
    public void save(User user) {
        
        String query= "insert into user(name, phone, email, address, loginName, password, role,loginStatus) values(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query, user.getName(), user.getPhone(), user.getEmail(), user.getAddress(),user.getLoginName(),user.getPassword(),user.getRole(),user.getLoginStatus());
    }
    

    @Override
    public void update(User user) {
      
         String query= "update user set name=?, phone=?, email=?, address=?, loginName=?, password=?, role=?,loginStatus=? where userId=?";
         jdbcTemplate.update(query, user.getName(), user.getPhone(), user.getEmail(), user.getAddress(),user.getLoginName(),user.getPassword(),user.getRole(),user.getLoginStatus(),user.getUserId());
    }

    

    @Override
    public void delete(Integer userId) {
       
        String query="delete from user where userId=?";
        jdbcTemplate.update(query, userId);
    }

    @Override
    public User findById(Integer userId) {
  
        String query="select * from user where userId=?";
		
	RowMapper<User> rowMapper= new UserRowMapperImpl();
		
	User user= jdbcTemplate.queryForObject(query, rowMapper, userId);
		
	return user;
    }

    @Override
    public List<User> findAll() {
        String query="select * from user";
        
        List<User> list = jdbcTemplate.query(query, new UserRowMapperImpl());
        
        return list;
    }

    @Override
    public List<User> findByProperty(String propName, Object propValue) {
       
         String query="select * from user where "+propName+" =?";
         
         List<User> list = jdbcTemplate.query(query, new UserRowMapperImpl(), propValue);
         
         return list;
    }
    
    
}
