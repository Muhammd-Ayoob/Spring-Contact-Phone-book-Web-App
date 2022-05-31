
package com.webapp.dao;

import com.webapp.model.Contact;
import java.util.List;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public interface ContactDAO {
    
    public void save(Contact contact);
    public void update(Contact contact);
    public void delete(Integer contactId);
    public Contact findById(Integer contactId);
    public List<Contact> findAll();
    public List<Contact> findByProperty(String propName, Object propValue);
}
