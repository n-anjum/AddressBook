<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="messages"/>
<html>
<head><title><fmt:message key="login.title"/></title></head>
<body>
<div>
    <h1 style="text-align:center;"><fmt:message key="login.title"/></h1>

    <div style="margin-left:450;">
        <c:url value="/user/loginValidation" var="loggingUser"/>
        <form action="${loggingUser}"method="post">

            <fieldset style="width:400px;">
                <table>
                    <tr>
                        <td><fmt:message key="login.userName"/></td>
                        <td><input type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="login.password"/></td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="<fmt:message key="login.submit"/>"/></td>
                    </tr>
                    <tr>
                        <c:url value="/homepage" var="homepage"/>
                        <td><a href="${homepage}">Home</a></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</div>

</body>
</html>