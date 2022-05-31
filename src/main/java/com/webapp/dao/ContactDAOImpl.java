
package com.webapp.dao;

import com.webapp.model.Contact;
import com.webapp.rm.ContactRowMapperImpl;
import com.webapp.rm.UserRowMapperImpl;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muhammad Ayoob Bugti
 */

@Repository
public class ContactDAOImpl implements ContactDAO{

    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    @Override
    public void save(Contact contact) {
        
        String query="insert into contact(userId,name,phone,email,address,remark) values(?,?,?,?,?,?)";
        
        jdbcTemplate.update(query, contact.getUserId(),contact.getName(),contact.getPhone(),contact.getEmail(),contact.getAddress(),contact.getRemarks());
        
        
    }

    @Override
    public void update(Contact contact) {
        String query="update contact set userId=?,name=?,phone=?,email=?,address=?,remark=? where contactId=?";
        jdbcTemplate.update(query,contact.getUserId(),contact.getName(),contact.getPhone(),contact.getEmail(),contact.getAddress(),contact.getRemarks(), contact.getContactId() );
    }

    @Override
    public void delete(Integer contactId) {
        String query="delete from contact where contactId=?";
        jdbcTemplate.update(query, contactId);
    }

    @Override
    public Contact findById(Integer contactId) {
        
        String query="select * from contact where contactId=?";
		
	RowMapper<Contact> rowMapper= new ContactRowMapperImpl();
		
	Contact contact= jdbcTemplate.queryForObject(query, rowMapper, contactId);
		
	return contact;
    }

    @Override
    public List<Contact> findAll() {
       
        String query="select * from contact";
        
        List<Contact> list = jdbcTemplate.query(query, new ContactRowMapperImpl());
        
        return list;
        
    }

    @Override
    public List<Contact> findByProperty(String propName, Object propValue) {
   
        String query="select * from contact where "+propName+" =?";
        
        List<Contact> list = jdbcTemplate.query(query, new ContactRowMapperImpl(), propValue);
        
        return list;
    }
    
}
