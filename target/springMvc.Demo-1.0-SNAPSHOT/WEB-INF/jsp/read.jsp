<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <title>查詢畫面</title>
</head>
<body>
    <div class="row justify-content-md-center">
        <input type="button" class="btn btn-outline-secondary" value="新增" onclick="location.href='add'">
    </div>
    <br>
    <div class="col-sm, badge-primary">瀏覽公布事項</div>
    <table width="100%" border="1">
        <tr class="table-danger">
            <th>標題</th>
            <th>發佈日期</th>
            <th>截止日期</th>
            <th>功能</th>
        </tr>
        <c:forEach var="items" items="${productlists}">
        <tr>
            <td>${items.title}</td>
            <td>${items.releasedate}</td>
            <td>${items.deadlinedate}</td>
            <td><a href="/productlist/delete?pkno=${items.pkno}" class="badge badge-secondary">刪除</a>&nbsp;<a href="/productlist/edit?pkno=${items.pkno}" class="badge badge-secondary">修改</a></td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
