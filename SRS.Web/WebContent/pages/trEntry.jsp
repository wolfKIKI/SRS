<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%
    	int SectionNo=Integer.parseInt(request.getParameter("SectionNo"));
    	
    	String ssn=request.getParameter("ssn");
    	
    	request.setAttribute("SectionNO", SectionNo);
    	request.setAttribute("ssn", ssn);
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="../servlet/addgrade" method="post">
	
	请输入成绩：<input type="text" name="grade" />
	<input type="submit" value="提交">
</form>
</body>
</html>