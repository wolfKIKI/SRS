<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ page import="model.Section" %>  
    <%
    	Section se=(Section)request.getAttribute("se");
    	int SectionNo=se.getSectionNo();
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="../servlet/updateSection" method="get">
<div class="field">
<input type="hidden" name="SectionNo" value="<%= SectionNo %>"/>
<h2>修改课程</h2>
课程名：<input type="text" name="course" value="<%=se.getRepresentedCourse().getCourseName() %>">
学期：<input type="text" name="semester" value="<%=se.getSemester() %>">
教室：<input type="text" name="room" value="<%=se.getRoom() %>">
容量：<input type="text" name="seatingCapacity" value="<%=se.getSeatingCapacity() %>">
开课老师：<input type="text" name="instructor" value="<%=se.getInstructor().getName() %>">

</div>


</form>
</body>
</html>