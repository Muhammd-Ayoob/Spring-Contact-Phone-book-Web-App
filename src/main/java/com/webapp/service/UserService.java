
package com.webapp.service;

import com.webapp.exception.UserBlockedException;
import com.webapp.model.User;
import java.util.List;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public interface UserService {
    
    public static final Integer LOGIN_STATUS_ACTIVE=1;
    
    public static final Integer LOGIN_STATUS_BLOCKED=2;
    
    public static final Integer ROLE_ADMIN=1;
    
    public static final Integer ROLE_USER=2;
    
    public void userRegister(User user);
    
    public User login(String loginName, String password) throws UserBlockedException;
    
    public List<User> getUsers();
    
    public void chanLoginStatus(Integer userId, Integer loginStatus);
    
    public User getUserByLoginName(String loginName);
}
