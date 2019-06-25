<%@page import="java.util.ArrayList"%>
<%@page import="site.membershipDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String str = "";

	String inputId = request.getParameter("id");
	String inputPwhint = request.getParameter("pwhint");
	String inputPwan = request.getParameter("pwan");
	
	membershipDAO dao = new membershipDAO();
	
	ArrayList list = dao.Id_Mail_Serch(inputId, inputPwhint, inputPwan);
	String id = (String)list.get(0);
	String pwhint = (String)list.get(1);
	String pwan = (String)list.get(2);
	String pw = (String)list.get(3);
	
	
	
	if(id == null && pwhint == null && pwan == null){
		str = "NO";
		out.write(str);
	}else if(id.equals(inputId) && pwhint.equals(inputPwhint) && pwan.equals(inputPwan)){
		str = pw;
		out.write(str);
	}
%>