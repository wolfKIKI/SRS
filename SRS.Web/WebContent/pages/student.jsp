<%@ page language="java" import="model.Person,model.Student" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%
    Person p=new Student(null,null,null,null);
	p=(Person)request.getAttribute("p");	
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
.field{
	margin:0px auto; width:500px;
	position:absolute; 
	top:50%; 
	left:50%; 
	margin:-150px 0 0 -150px; 
	width:300px; 
	height:300px; 
	}
.link{
	border:none;
	margin-bottom:50px;
}
</style>
</head>

<body>
	<form>
    	<div class="field">
    	<a href="../servlet/ScheduleOfClasses}" class="link">查看学习计划</a><br />
        	<a href="enrollCourse.jsp?name=${p.name}&ssn=${p.ssn}" class="link">选课</a><br />
            <a href="../servlet/gradesOfStudent?ssn=${p.ssn }" class="link">查看成绩</a>

        </div>
    </form>
</body>
</html>
