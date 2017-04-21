<%@ page isELIgnored="false"%>
<%@ page import="java.util.Set"%>
<%@ page import="redis.clients.jedis.Jedis"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student System</title>
</head>
<body>
	<a href="insert.jsp">添加</a>
	<c:if test="${requestScope.pageCount >0}">
		<table border="1">
			<tr>
				<th>id</th>
				<th>姓名</th>
				<th>出生日期</th>
				<th>备注</th>
				<th>平均分</th>
				<th colspan="2">操作</th>
			</tr>
			<c:forEach items="${requestScope.students}" var="student">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.birthday}</td>
					<td>${student.description}</td>
					<td>${student.avgscore}</td>
					<td><a href="update?id=${student.id}">修改</a></td>
					<td><a href="delete?id=${student.id}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<c:forEach var="i" begin="1" end="${requestScope.pageCount}" step="1">
			<c:if test="${i==1}">
				页数
			</c:if>
			<a href="info?page=${i}">${i}</a>
		</c:forEach>
	</c:if>
	<c:if test="${requestScope.pageCount <= 0}">
		没有学生信息，请添加
	</c:if>

</body>
</html>
