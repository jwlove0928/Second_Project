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
			
				membershipDAO dao = new membershipDAO();
				membershipDTO dto2 = dao.select(dto);
				
				if(dto2 != null){
					str = "NO";
				}else{
					str = "YES";
				}
			%>
		</body>
</html>