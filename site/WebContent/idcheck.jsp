<%@page import="site.membershipDTO"%>
<%@page import="site.membershipDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<jsp:useBean id="dto" class="site.membershipDTO"></jsp:useBean>
		<jsp:setProperty property="*" name="dto"/>
	</head>
		<body>
			<%
				String str = "";
				
				String inputId = request.getParameter("id");
				
				membershipDAO dao = new membershipDAO();
				
				String result1 = dao.select(inputId);
				
				if(result1.equals(inputId)){
					str = "YES";
				}else{
					str = "NO";
				}
			%>
		</body>
</html>