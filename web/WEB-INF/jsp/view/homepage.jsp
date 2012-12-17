<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en"/>
<html>
<head><title><fmt:message key="home.title"/></title></head>
<body>

<div align="center">
    <h3 align="center">Wellcome To This Addressbook Application.</h3>
    <tr>
        <td>
            <p align="center">New User ?? Register Here</p>
            <a href="<c:url value="/registration/register" />">Register</a>
        </td>
    </tr>
    <tr>
        <td>
            <p align="center">Already have Account ?? please Login</p>
            <a href="<c:url value="/user/loginForm"/>">login</a>
        </td>
    </tr>
    </table>
</div>
</body>
</html>