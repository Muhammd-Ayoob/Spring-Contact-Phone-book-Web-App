
package com.webapp.controller;

import com.webapp.model.Contact;
import com.webapp.service.ContactService;
import com.webapp.service.ContactServiceImpl;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
@Controller
public class ContactController {
    @Autowired
    private ContactService service= new ContactServiceImpl();
    
    @RequestMapping("/contact_form")
    public String conatctForm(Model model){
        Contact contact = new Contact();
        model.addAttribute("command", contact);
        
        return "contact_form";
    }
    
    
    @RequestMapping("/save_contact")
    public String saveContact(@ModelAttribute("command") Contact contact, Model model, HttpSession session){
        try{
        Integer userId = (Integer)session.getAttribute("userId");
        contact.setUserId(userId);
        service.save(contact);
        return "redirect:contact_list?act=sv";
        }
        catch(Exception exception){
            model.addAttribute("error","Failed to add contact");
            return "contact_form";
        }
    }
    
    @RequestMapping("/contact_list")
    public String conatctList(Model model, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userId");
        List<Contact> list= service.findUserContact(userId);
        model.addAttribute("list", list);
        
        return"contact_list";
    }
    
    @RequestMapping("/delete_contact")
    public String deleteContact(@RequestParam("cId") Integer id){
        
        service.delete(id);
        
        return "redirect:contact_list?act=del";
    }
    
    @RequestMapping("/edit_contact")
    public String prepareEditForm(Model model, @RequestParam("cId") Integer id, HttpSession session){
        session.setAttribute("contactId", id);
        Contact contact = service.findById(id);
        
        model.addAttribute("command", contact);
        
        return "contact_edit_form";
    }
    
    
    @RequestMapping("/update_contact")
    public String updateContact(@ModelAttribute("command") Contact contact, Model model, HttpSession session){
        try{
            Integer userId = (Integer) session.getAttribute("userId");
            Integer contactId = (Integer) session.getAttribute("contactId");
            contact.setUserId(userId);
            contact.setContactId(contactId);
            service.update(contact);
            return "redirect:contact_list?act=ed";
        }
        catch(Exception exception){
            model.addAttribute("error","Failed to Edit contact");
            return "contact_form";
        }
    }
    
    @RequestMapping("/search")
    public String search(Model model, HttpSession session, @RequestParam("freeText") String text){
        
        Integer userId = (Integer) session.getAttribute("userId");
        
        model.addAttribute("list",service.findUserContact(userId, text));
        
        return "contact_list";
    }
    
}
