/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapp.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
@Controller
public class TestController {
    
    @RequestMapping("/test")
    public String home(){
        return "test";
    }
    
    @RequestMapping("/time")
    @ResponseBody
    public String getTime(){
        Date date= new Date();
        
       return date.toString();
    }
}
