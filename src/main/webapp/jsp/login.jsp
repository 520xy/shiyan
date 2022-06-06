<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="/exercise2/css/login.css" rel="stylesheet">
</head>
<body>
<div id="loginDiv" style="height: 350px">
    <form action="/exercise2/userLoginServlet" id="form" method="post">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${login_msg}${register_msg}</div>
        <p>Username:<input id="username" name="username" type="text" value="${cookie.userName.value}"></p>

        <p>Password:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>
        <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="/exercise2/jsp/register.jsp">没有账号？</a>
        </div>
    </form>
</div>

</body>
</html>
