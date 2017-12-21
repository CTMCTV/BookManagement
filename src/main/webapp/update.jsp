<%--
  Created by IntelliJ IDEA.
  User: yuanxiang
  Date: 2017/12/20
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>修改图书</title>
</head>
<body>
<%@include file="common.jsp"%>

<form action="/updateData.do?id=${book.id}" method="post"  align="center">
    <table border="1"  align="center">
        <tr align="center">
            <td>图书名称</td>
            <td><input type="text" name="name" value="${book.name}"/></td>
        </tr>
        <tr align="center">
            <td>图书作者</td>
            <td><input type="text" name="author" value="${book.author}"/></td>
        </tr>
        <tr align="center">
            <td>图书分类号</td>
            <td><input type="text" name="bcn" value="${book.bcn}"/></td>
        </tr>
        <tr align="center">
            <td>图书价格</td>
            <td><input type="text" name="price" value="${book.price}"/></td>
        </tr>
        <tr align="center">
            <td>图书描述</td>
            <td><textarea rows="5" cols="30" name="description" >${book.description}</textarea></td>
        </tr>
    </table>
    <td><input align="center" type="submit" value="提交" name="submit" ></td>
</form>

</body>
</html>
