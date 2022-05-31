
package com.webapp.rm;

import com.webapp.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public class UserRowMapperImpl implements RowMapper<User>{
    
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
                User user= new User();
		
		user.setUserId(rs.getInt("userId"));
		user.setName(rs.getString("name"));
		user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setLoginName(rs.getString("loginName"));
                user.setLoginStatus(rs.getInt("loginStatus"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getInt("role"));
               
		return user;
	}
}
