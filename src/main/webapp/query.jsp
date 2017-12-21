<%--
  Created by IntelliJ IDEA.
  User: yuanxiang
  Date: 2017/12/21
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书列表</title>
</head>
<body>
<%@include file="common.jsp"%>
<table align="center" width="70%" border="1">
    <tr>
        <th>图书名称</th>
        <th>图书作者</th>
        <th>分类号</th>
        <th>价格</th>
        <th>描述</th>
        <th>操作</th>
    </tr>
 <c:forEach items="${pb.beanList}" var="book">
     <tr>
         <td>${book.name}</td>
         <td>${book.author}</td>
         <td>${book.bcn}</td>
         <td>${book.price}</td>
         <td>${book.description}</td>
         <td>
            <a href="update.do?id=${book.id}">修改</a> <a href="delete.do?id=${book.id}">删除</a>
         </td>

     </tr>

 </c:forEach>
</table>
<br/>
<div align="center">
    当前第${pb.currentPage}页，总共${pb.totalPage}页。
    <c:choose>
        <c:when test="${pb.currentPage>1}">
            <a href="/getList.do?currentpage=1">首页</a>
            <a href="/getList.do?currentpage=${pb.currentPage-1}">上一页</a>
        </c:when>
        <c:otherwise>
            首页|上一页
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${pb.currentPage < pb.totalPage}">
            <a href="/getList.do?currentpage=${pb.currentPage+1}">下一页</a>
            <a href="/getList.do?currentpage=${pb.totalPage}">尾页</a>
        </c:when>
        <c:otherwise>
            下一页|尾页
        </c:otherwise>
    </c:choose>

</div>

</body>
</html>
