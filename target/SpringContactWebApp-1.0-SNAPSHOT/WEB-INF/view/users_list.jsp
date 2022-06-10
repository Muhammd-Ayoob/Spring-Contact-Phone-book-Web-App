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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        
        
        
        <script>
            
           function changeStatus(uId, status){
               
               $.ajax({
                   url: "change_status",
                   data: {userId:uId, lStatus: status},
                   success: function (data) {
                        alert(data);
                    }
               });
           }
        </script>
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
                   
                    <h3>Users List</h3>
               
                    <table border="1" cellpadding="2" width="100%">
                            <tr>
                                <th>SR</th>
                                <th>ID</th>
                                <th>NAME</th>
                                <th>PHONE</th>
                                <th>EMAIL</th>
                                <th>ADDRESS</th>
                                <th>USERNAME</th>
                                <th>STATUS</th>
                                <th>ACTION</th>

                            </tr>

                            
                            <c:forEach var="list" items="${usersList}" varStatus="st">

                            <tr>
                                <td>${st.count}</td>
                                <td>${list.userId}</td>
                                <td>${list.name}</td>
                                <td>${list.phone}</td>
                                <td>${list.email}</td>
                                <td>${list.address}</td>
                                <td>${list.loginName}</td>
                                <td>
                                    <select id="status${list.userId}" onchange="changeStatus(${list.userId},$(this).val())">
                                        
                                        <option value="1">Active</option>
                                        <option value="2">Blocked</option>
                                    </select>
                                    
                                    <script>
                                        $("#status${list.userId}").val(${list.loginStatus});
                                        
                                    </script>
                                    
                                </td>

                                
                                <td><a href="#">Edit</a> | <a href="#">Delete</a></td>

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
