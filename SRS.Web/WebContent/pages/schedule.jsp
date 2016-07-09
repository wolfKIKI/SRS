<%@ page language="java" import="model.ScheduleOfClasses,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	ScheduleOfClasses schedule=(ScheduleOfClasses)request.getAttribute("schedule");
    	int semester=schedule.getSemester();
    	HashMap<String,String> course=schedule.getSectionsOffered();
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>第${semester}学期要选的课：</h2>
<table>
<c:forEach var="hashMap" items="${course}" >
<tr><td>${hashMap.key}</td><td>${hashMap.value }</td>
</tr>
</c:forEach></table>
</body>
</html>
