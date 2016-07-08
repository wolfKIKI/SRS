<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.List" %>
   	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form >
	<h2>课程列表</h2>
	<table>
	<thead><td>学期</td><td>课程名</td><td>教室</td><td>容量</td><td>开课老师</td><td>删除</td><td>修改	</td></th>
	<tbody>
	<c:forEach items="${list}" var="se">
	<th><td>${se.getSemester()}</td>
	<td>${se.getRepresentedCourse().getCourseName()}</td>
	<td>${se.getRoom()}</td>
	<td>${se.getSeatingCapacity()}</td>
	<td>${se.getInstructor().getName() }</td>
	<td><a href="../servlet/getSection.jsp?sectionNo=${se.getSectionNo()}">修改</td><td><a href="../servlet/deleteSection?sectionNo=${se.getSectionNo()}"></a></td></th>
	
	</c:forEach>
	</tbody>
	</table>


</form>
</body>
</html>