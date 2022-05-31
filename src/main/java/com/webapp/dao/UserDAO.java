
package com.webapp.dao;

import com.webapp.model.User;
import java.util.List;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public interface UserDAO {
    
    public void save(User user);
    public void update(User user);
    public void delete(Integer userId);
    public User findById(Integer userId);
    public List<User> findAll();
    public List<User> findByProperty(String propName, Object propValue);
}
