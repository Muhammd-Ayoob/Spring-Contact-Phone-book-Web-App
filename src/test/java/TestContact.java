
import com.webapp.config.SpringRootConfig;
import com.webapp.dao.ContactDAO;
import com.webapp.dao.ContactDAOImpl;
import com.webapp.model.Contact;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public class TestContact {
    
    public static void main(String[] args) {
        
        ApplicationContext context= new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        ContactDAO cdao= context.getBean("contactDao", ContactDAOImpl.class);
        
        List<Contact> list= cdao.findByProperty("remark", "....");
        
        for(Contact contact: list){
            System.out.println(contact);
        }
        
        System.out.println("*****************************************************************************");
        System.out.println("                     *********************************");
        System.out.println("*****************************************************************************");
    }
}
