<%-- 
    Document   : index
    Created on : Jun 2, 2022, 12:15:54 AM
    Author     : Muhammad Ayoob Bugti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <td height="350px" valign="top">
                    <h3>Contact List</h3>
                    <c:if test="${param.act eq 'sv'}">
                        <p class="success">Contact Added Successfully!</p>
                    </c:if>
                     <c:if test="${param.act eq 'del'}">
                        <p class="success">Contact Deleted Successfully!</p>
                    </c:if>
                        
                     <c:if test="${param.act eq 'ed'}">
                        <p class="success">Contact updated successfully!</p>
                    </c:if>
                    
                        <form action="<s:url value="/search"></s:url>">
                            <input type="text" name="freeText" placeholder="Enter Text to search"/>
                            <button>find</button>
                        </form>
                        
                            <br>
                    <table border="1">
                        <tr>
                            <th>SR</th>
                            <th>ContactId</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Remark</th>
                            <th>Action</th>
                            
                        </tr>
                        
                        <c:if test="${empty list}">
                            <tr>
                                <td align="center" colspan="8" class="error">No records present</td>
                            </tr>
                            
                        </c:if>
                        
                        <c:forEach var="contactList" items="${list}" varStatus="st">
                            
                            <tr>
                            <td>${st.count}</td>
                            <td>${contactList.contactId}</td>
                            <td>${contactList.name}</td>
                            <td>${contactList.phone}</td>
                            <td>${contactList.email}</td>
                            <td>${contactList.address}</td>
                            <td>${contactList.remarks}</td>
                            
                            <s:url var="delete" value="delete_contact">
                                <s:param name="cId" value="${contactList.contactId}"/>
                            </s:url>
                            
                             <s:url var="edit" value="edit_contact">
                                <s:param name="cId" value="${contactList.contactId}"/>
                            </s:url>
                            <td><a href="${edit}">Edit</a> | <a href="${delete}">Delete</a></td>
                            
                        </tr>
                            
                        </c:forEach>
                    </table>
                   
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
