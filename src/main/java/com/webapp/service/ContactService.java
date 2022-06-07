
package com.webapp.service;
import com.webapp.model.Contact;
import java.util.List;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public interface ContactService {
    
    public void save(Contact contact);
    public void update(Contact contact);
    public void delete(Integer id);
    public void delete(Integer[] ids);
    public List<Contact> findUserContact(Integer userId);
    public List<Contact> findUserContact(Integer userId, String text);
    
}
