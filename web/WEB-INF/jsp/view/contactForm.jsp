<%--
  Created by IntelliJ IDEA.
  User: anjum
  Date: 10/9/12
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="en"/>
<html>
<head><title><fmt:message key="newcontact.title"/></title></head>
<body>
<div>
    <h1 style="text-align:center;"><fmt:message key="newcontact.title"/></h1>
    <c:choose>
    <c:when test="${wantToEdit != null}">
    <c:url value="/contact/updateContact/${wantToEdit}" var="updateContactUrl"/>
    <form action="${updateContactUrl}" method="post">
        </c:when>
        <c:otherwise>
            <c:url value="/contact/addNewContact" var="addNewContactUrl"/>
        <form action="${addNewContactUrl}" method="post">
            </c:otherwise>
            </c:choose>
            <fieldset style="width:400px;margin-left:450;">
                <table>
                    <tr>
                        <td><fmt:message key="newcontact.name"/></td>
                        <td><input type="text" name="name" value="${contact.name}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="newcontact.address"/></td>
                        <td><textarea rows="" cols="30" name="address">${contact.address}</textarea></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="newcontact.email"/></td>
                        <td><input type="text" name="email" value="${contact.email}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="newcontact.phoneno"/></td>
                        <td><input type="text" name="phoneNo" value="${contact.phoneNo}"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="<fmt:message key="newcontact.submit"/>"/></td>
                    </tr>
                    <tr>
                        <td>
                            <c:url value="/user/logout" var="userLogOut"/>
                            <a href="${userLogOut}">Logout</a>

                        </td>
                        <td>
                            <c:url value="/addressbook/homepage" var="homepage"/>
                            <a href="${homepage}">Home</a>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
</div>

</body>
</html>