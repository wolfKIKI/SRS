<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.List" %>
   	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   	<% int SectionNo=(int)request.getAttribute("SectionNo"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body><table>
	
	<c:forEach items="${list}" var="s">
	<tr><td>${s}</td><td><a href="trEntry.jsp?SectionNo=${SectionNo }&ssn=${s}">录成绩</a></td></tr>
	</c:forEach>
	</table>
</body>
</html>