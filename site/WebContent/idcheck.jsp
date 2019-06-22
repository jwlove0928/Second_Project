<%@page import="site.membershipDTO"%>
<%@page import="site.membershipDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
			<%
				String str = "";
				
				String inputId = request.getParameter("id");
				
				membershipDAO dao = new membershipDAO();
				
				membershipDTO dto = dao.select(inputId);
				
				if(dto == null){
					str = ",YES";
					out.write(str);
				}else{
					str = ",NO";
					out.write(str);
				}
			%>
