<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加学生</title>
</head>
<body>
	<form action="insertResult" method="post" accept-charset="ISO-8859-1">
		<table border="1">
			<tr>
				<td>学生id</td>
				<td><input type="number" name="id" /></td>
			</tr>
			<tr>
				<td>学生姓名</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td><input type="text" name="birthday" placeholder="xxxx/xx/xx"/></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>平均分</td>
				<td><input type="number" name="avgscore" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>

</body>
</html>