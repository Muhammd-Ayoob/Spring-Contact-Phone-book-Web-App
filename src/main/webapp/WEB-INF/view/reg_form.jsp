<%-- 
    Document   : index
    Created on : Jun 2, 2022, 12:15:54 AM
    Author     : Muhammad Ayoob Bugti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link href="static/css/style.css" rel="stylesheet" type="text/css">
    </head>
    
    <s:url var="bg_url" value="static/images/image.jpg"></s:url>
    <body background="${bg_url}">
       
        <table border="1" width="80%" align="center">
            <tr>
                <td height="100px">
                    <jsp:include page="include/header.jsp"/>
                </td>
            </tr>
            
            <tr>
                <td height="30px">
                    
                    <jsp:include page="include/menu.jsp"/>
                </td>
                
            </tr>   
            
            
            <tr>
                <td height="350px">
                    <h3>User Registration</h3>
                    <c:if test="${error!=null}">
                        <p class="error">${error}</p>
                    </c:if>
                        
                    <c:if test="${param.act eq 'lo'}">
                        <p class="success">Logout successfully! Thanks for using the contact Application</p>
                    </c:if>
                        
                    <s:url var="register" value="/register"></s:url>
                    
                    <f:form action="${register}" modelAttribute="command">
                        
                        <table border="1">
                            
                            <tr>  
                                <td>Name</td>
                                <td><f:input path="user.name"></f:input></td>
                            </tr>
                            
                            <tr>  
                                <td>Phone</td>
                                <td><f:input path="user.phone"></f:input></td>
                            </tr>
                            
                            <tr>  
                                <td>Email</td>
                                <td><f:input path="user.email"></f:input></td>
                            </tr>
                            
                            <tr>  
                                <td>Address</td>
                                <td><f:textarea path="user.address"></f:textarea></td>
                            </tr>
                            
                            <tr>
                                <td>Username</td>
                                <td> <f:input path="user.loginName"></f:input></td>
                            </tr>
                            
                            <tr>
                                <td>Password</td>
                                <td><f:password path="user.password"></f:password></td>
                            </tr>
                            
                            
                            <tr>
                                <td align="right" colspan="2">
                                <f:button>submit</f:button><br>
                                    
                                </td>
                            </tr>
                            
                        </table>
                    </f:form>
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
