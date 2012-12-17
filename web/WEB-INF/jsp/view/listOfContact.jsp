<%--
  Created by IntelliJ IDEA.
  User: sazzadur
  Date: 10/3/12
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en"/>
<html>
<head><title><fmt:message key="home.title"/></title></head>
<body>

<div align="center">
    <strong> Contact list of ${loggedInUser.name}</strong>
    <br><br>
    <table cellspacing="10" cellpadding="10">
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Phone no</th>
            <th>Email</th>

        </tr>
        <c:forEach var="contact" items="${contactList}">
            <tr>
                <td>${contact.name}</td>
                <td>${contact.address}</td>
                <td>${contact.phoneNo}</td>
                <td>${contact.email}</td>
                <td><a href="<c:url value="/contact/deleteContact/${contact.id}"/>">Delete</a></td>
                <td><a href="<c:url value="/contact/editContactForm/${contact.id}"/>">Edit</a></td>
            </tr>

        </c:forEach>
        <tr>
            <td>
            <a href="<c:url value="/user/logout"/>">Log out</a>
            </td>
            <td>
                <a href="<c:url value="/contact/newContactForm"/>">Add New Contact</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>