<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="model.Person,model.Professor" %>
     <%
    Person p=new Professor(null,null,null,null);
	p=(Person)request.getAttribute("p");	
    String name=p.getName();
    String ssn=p.getSsn();
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
        	<a href="../servlet/findSectionsByTeach?name=${name }" class="link">录学生成绩</a><br />
            <a href="../servlet/findSectionsByTeach?name=${name }" class="link">查看所授课程</a>

        </div>
    </form>
</body>
</html>
