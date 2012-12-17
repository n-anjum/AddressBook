<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en"/>
<html>
<head><title><fmt:message key="register.title"/></title></head>
<body>
<div>
    <h1 style="text-align:center;"><fmt:message key="register.title"/></h1>
    <c:url value="/registration/addNewUser" var="addNewUserUrl"/>
    <p align="center">All * marked Fields must be filled</p>
    <p align="center">${passwordMismatch}</p>
    <p align="center">${registrationSuccessMessage}</p>
    <form action="${addNewUserUrl}" method="post">
        <fieldset style="width:400px;margin-left:450;">
            <p>${errorMessege}</p>
            <table>
                <tr>
                    <td><fmt:message key="register.userName"/></td>
                    <td><input type="text" name="name"/></td>
                    <td>*</td>
                </tr>
                <tr>
                    <td><fmt:message key="register.password"/></td>
                    <td><input type="password" name="password"/></td>
                    <td>*</td>

                </tr><tr>
                <td><fmt:message key="register.confPassword"/></td>
                <td><input type="password" name="confPassword"/></td>
                <td>*</td>
            </tr>
                <tr>
                    <td><input type="submit" value="<fmt:message key="register.submit"/>"/></td>
                </tr>
                <tr>
                    <c:url value="/homepage" var="homepage"/>
                    <td><a href="${homepage}">Home</a></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>

</body>
</html>