<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="/exercise2/brandUpdataServlet" method="post">
    <input type="hidden" value="${brand.id}" name="id">
    <label for="brandName">品牌名称</label>
    <input type="text" name="brandName" id="brandName" value="${brand.brandName}"/><br>
    <label for="companyName">企业名称</label>
    <input type="text" name="companyName" id="companyName" value="${brand.companyName}"/><br>
    <label for="ordered">排序</label>
    <input type="text" name="ordered" id="ordered" value="${brand.ordered}"/><br>
    信息描述<textarea name="description" id="description" >${brand.description}</textarea><br>
    <c:if test="${brand.status==0}">
    <label for="status0">禁用</label><input type="radio" name="status"  value="0" id="status0" checked/>
    <label for="status1">启用</label><input type="radio" name="status"  value="1" id="status1"/><br>
    </c:if>
    <c:if test="${brand.status==1}">
        <label for="status0">禁用</label><input type="radio" name="status"  value="0" id="status0" />
        <label for="status1">启用</label><input type="radio" name="status"  value="1" id="status1" checked/><br>
    </c:if>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
