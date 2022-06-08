 <%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<s:url var="logout_url" value="/logout"></s:url>

<s:url var="user_reg" value="/reg_form"></s:url>

<s:url var="contactform" value="/contact_form"></s:url>

<s:url var="user_dash" value="/user_dash"></s:url>

<s:url var="clist" value="/contact_list"></s:url>

    
<c:if test="${sessionScope.userId==null}">
    
    <a href="#">Home</a> | <a href="#">Login</a> | <a href="${user_reg}">Register</a> | <a href="#">About</a>
</c:if>
    <c:if test="${sessionScope.userId!=null && sessionScope.role==1}">
    
    <a href="#">Home</a> | <a href="#">User List</a> | <a href="${logout_url}">Logout</a>
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role==2}">
    
    <a href="${user_dash}">Home</a> | <a href="${contactform}">Add Contact</a> | <a href="${clist}">Contact List</a> | <a href="${logout_url}">Logout</a>
</c:if>
