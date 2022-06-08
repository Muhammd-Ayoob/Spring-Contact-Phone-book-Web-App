/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapp.service;

import com.webapp.dao.ContactDAOImpl;
import com.webapp.model.Contact;

import com.webapp.rm.ContactRowMapperImpl;
import com.webapp.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    ContactDAOImpl contactDao;
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    
    @Override
    public void save(Contact contact) {
        contactDao.save(contact);
       
    }

    @Override
    public void update(Contact contact) {
      
       contactDao.update(contact);
    }

    @Override
    public void delete(Integer id) {
 
        contactDao.delete(id);
    }

    @Override
    public void delete(Integer[] contactIds) {

        String ids= StringUtil.commaSepratedString(contactIds);
        
        String query="delete from contact where contactId in("+ids+")";
        
        jdbcTemplate.update(query);
    }

    @Override
    public List<Contact> findUserContact(Integer userId) {
  
        return contactDao.findByProperty("userId", userId);
    }

    @Override
    public List<Contact> findUserContact(Integer userId, String text) {
        String query="SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? AND (name LIKE '%"+text+"%' OR remark LIKE '%"+text+"%' OR phone LIKE '%"+text+"%' OR email LIKE '%"+text+"%' OR address LIKE '%"+text+"%')";
        
        
        List<Contact> list = jdbcTemplate.query(query, new ContactRowMapperImpl(),userId);
        
        return list;
    }

    @Override
    public Contact findById(Integer id) {
       
        return contactDao.findById(id);
    }
    
}
