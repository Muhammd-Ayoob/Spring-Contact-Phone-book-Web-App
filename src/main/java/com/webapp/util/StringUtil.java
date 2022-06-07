
package com.webapp.util;

/**
 *
 * @author Muhammad Ayoob Bugti
 */
public class StringUtil {
    
    public static String commaSepratedString(Object[] items){
        
        StringBuilder  builder= new  StringBuilder();
        
        for(Object item: items){
            
            builder.append(item).append(",");
        }
        
        if(builder.length()>0){
            
            builder.deleteCharAt(builder.length()-1);
        }
        
        return builder.toString();
    }
}
