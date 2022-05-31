
import com.webapp.config.SpringRootConfig;
import com.webapp.dao.UserDAO;
import com.webapp.dao.UserDAOImpl;
import com.webapp.model.User;
import java.util.List;
import javax.sql.DataSource;
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
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
      UserDAO userDao = context.getBean("userDao", UserDAOImpl.class);
        
     
        
      List<User> list = userDao.findByProperty("address", "SBA");
      
      for(User user: list){
          System.out.println(user);
      }
      
        System.out.println("***************CONGRATS ITS RUNNING SUCESSFULLY**********************");
    }
}
