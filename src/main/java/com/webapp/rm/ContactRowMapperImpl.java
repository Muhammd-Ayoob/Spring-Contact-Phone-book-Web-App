
package com.webapp.rm;

import com.webapp.model.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public class ContactRowMapperImpl implements RowMapper<Contact>{

    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        Contact contact= new Contact();
	
        contact.setContactId(rs.getInt("contactId"));
        contact.setUserId(rs.getInt("userId"));
	contact.setName(rs.getString("name"));
	contact.setAddress(rs.getString("address"));
        contact.setEmail(rs.getString("email"));
        contact.setRemarks(rs.getString("remark"));
        contact.setPhone(rs.getString("phone"));
       
        
        return contact;
    }
    
}
