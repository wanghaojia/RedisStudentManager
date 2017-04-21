<%@ page isELIgnored="false"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<body>
<form action="updateResult" method="post" accept-charSet="ISO-8859-1">
		<table border="1">
			<tr>
				<td>学生id</td>
				<td><input type="hidden" name="id" value="${requestScope.student.id}"/>${requestScope.student.id}</td>
			</tr>
			<tr>
				<td>学生姓名</td>
				<td><input type="text" name="name" value="${requestScope.student.name}"/></td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td><input type="text" name="birthday" value="${requestScope.student.birthday}"/></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input type="text" name="description" value="${requestScope.student.description}"/></td>
			</tr>
			<tr>
				<td>平均分</td>
				<td><input type="text" name="avgscore" value="${requestScope.student.avgscore}"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="修改" /></td>
			</tr>
		</table>
	</form>
	<a href="info">返回</a>
</body>
</html>