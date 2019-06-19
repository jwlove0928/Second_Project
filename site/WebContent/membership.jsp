<%@page import="site.membershipDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
		<jsp:useBean id="dto" class="site.membershipDTO"></jsp:useBean>
		<jsp:setProperty property="*" name="dto"/>
		<body>
		
		<%
			membershipDAO dao = new membershipDAO();
			dao.insert(dto); 
		%>
			<%= dto %>
			아이디 : <%= dto.getId() %>
			비밀번호 : <%= dto.getPw() %>
		</body>
</html>