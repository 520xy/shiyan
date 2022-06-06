<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>遍历</title>
</head>
<body>
<h1>${user.userName}，欢迎你</h1>
<input type="button" value="增加" id="add" ><br>
<table cellspacing="0" border="1" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
<c:forEach items="${brands}" var="brand">
    <tr align="center" >
        <td>${brand.id}</td>
        <td>${brand.brandName}</td>
        <td>${brand.companyName}</td>
        <td>${brand.ordered}</td>
        <td>${brand.description}</td>
        <td><c:if test="${brand.status==1}">启动</c:if>
            <c:if test="${brand.status==0}">静止</c:if></td>
        <td><a href="/exercise2/brandSelectServlet?id=${brand.id}">修改</a> <a href="/exercise2/brandDeleteServlet?id=${brand.id}">删除</a></td>
    </tr>
</c:forEach>
</table>
<script>
    document.getElementById("add").onclick=add;
    function add()
    {
        location.href="/exercise2/html/add.html";
    }
</script>


</body>
</html>
