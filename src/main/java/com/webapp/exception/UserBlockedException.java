
package com.webapp.exception;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public class UserBlockedException extends Exception{
    
    public UserBlockedException(){
        
    }
    
    public UserBlockedException(String errorDec){
        
        super(errorDec);
    }
    
}
