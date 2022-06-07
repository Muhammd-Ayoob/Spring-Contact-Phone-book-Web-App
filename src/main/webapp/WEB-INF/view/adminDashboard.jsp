<%-- 
    Document   : index
    Created on : Jun 2, 2022, 12:15:54 AM
    Author     : Muhammad Ayoob Bugti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
<!--        <link href="static/css/style.css" rel="stylesheet" type="text/css">-->
        <link href="static/css/style.css" rel="stylesheet" type="text/css">
    </head>
    
    <s:url var="bg_url" value="static/images/image.jpg"></s:url>
    <body background="${bg_url}">
       
        <table border="1" width="80%" align="center">
            <tr>
                <td height="50px">
                    <jsp:include page="include/header.jsp"/>
                    
                </td>
            </tr>
            
            <tr>
                <td height="30px>
                    <jsp:include page="include/menu.jsp"/>
                </td>
                
            </tr>   
            
            
            <tr>
                <td height="350px">
                    
                    Content will added here
                    <h1>ADMIN DASHBOARD</h1>
                </td>
                
            </tr>   
            
            <tr>
                <td height="20px">
                    
                    <jsp:include page="include/footer.jsp"/>
                </td>
                  
            </tr>
        </table>
        
    </body>
</html>
