<%@page import="site.membershipDTO"%>
<%@page import="site.membershipDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String inputId = request.getParameter("loginid");
	String inputPw = request.getParameter("loginpw");
	
	
	membershipDAO dao = new membershipDAO();
	
	membershipDTO dto = dao.select(inputId);
	dto.getId();
	dto.getPw();
	
	if(dto == null) {
		out.write();
	}else{
		if (dto.equals(dto.getId()) && dto.equals(dto.getPw())){
		message = dto.getId() + "님 환영합니다.";
		out.write(message);
		}
	}
%>