
package com.webapp.controller;

import com.webapp.command.LoginCommand;
import com.webapp.exception.UserBlockedException;
import com.webapp.model.User;
import com.webapp.service.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muhammad Ayoob Bugti
 */

@Controller
public class UserController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping("index")
    public String index(Model model){
       model.addAttribute("command", new LoginCommand());
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String formHandler(@ModelAttribute("command") LoginCommand command, Model model, HttpSession session){
        try {
            User user = userService.login(command.getLoginName(), command.getPassword());
            
            if(user== null){
                model.addAttribute("error", "Login failed Enter valid credentials");
                return "index";
            }
            else{
                if(user.getRole().equals(UserService.ROLE_ADMIN)){
                    addUserInSession(user, session);
                    return "redirect:admin_dash";
                }
                else if(user.getRole().equals(UserService.ROLE_USER)){
                    addUserInSession(user, session);
                    return "redirect:user_dash";
                }
                else{
                     model.addAttribute("error", "Invalid user Role");
                     return "index";
                }
            }
        } catch (UserBlockedException ex) {
            model.addAttribute("error", ex.getMessage());
            return "index";
        }
    }
    
    @RequestMapping("/user_dash")
    public String userDashboard(){
       
        return "userDashboard";
    }
    
    
    @RequestMapping("/admin_dash")
    public String adminDashboard(){
       
        return "adminDashboard";
    }
    
    
     @RequestMapping("/logout")
    public String logout(HttpSession session){
       session.invalidate();
        return "redirect:index";
    }
    
    
    private void addUserInSession(User user, HttpSession session){
        session.setAttribute("user", user);
        session.setAttribute("userId", user.getUserId());
        session.setAttribute("role", user.getRole());
    }

}
