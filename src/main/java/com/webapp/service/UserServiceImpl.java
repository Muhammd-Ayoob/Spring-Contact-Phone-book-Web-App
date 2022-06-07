package com.webapp.service;

import com.webapp.dao.UserDAO;
import com.webapp.dao.UserDAOImpl;
import com.webapp.exception.UserBlockedException;
import com.webapp.model.User;
import com.webapp.rm.UserRowMapperImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAOImpl userDao;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void userRegister(User user) {
  
        userDao.save(user);
    }

    @Override
    public User login(String loginName, String password) throws UserBlockedException {
   
        String query="select *from user where loginName=? and password =?";
       try{ 
      User user = jdbcTemplate.queryForObject(query, new UserRowMapperImpl(), loginName, password);
      
      if(user.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)){
          throw new UserBlockedException("your account is blocked, contact to admin.");
      }
      else{
          return user;
      }
     }catch(EmptyResultDataAccessException exception){
         return null;
     }
    }

    @Override
    public List<User> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void chanLoginStatus(Integer userId, Integer loginStatus) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
