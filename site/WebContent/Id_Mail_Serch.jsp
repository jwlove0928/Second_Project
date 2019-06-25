<%@page import="java.util.ArrayList"%>
<%@page import="site.membershipDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String str = "";

	String inputName = request.getParameter("name2");
	String inputMail = request.getParameter("mail");
	String inputMail2 = request.getParameter("mail2");
	
	membershipDAO dao = new membershipDAO();
	
	ArrayList list = dao.Id_Mail_Serch(inputName, inputMail, inputMail2);
	String name = (String)list.get(0);
	String mail = (String)list.get(1);
	String mail2 = (String)list.get(2);
	String id = (String)list.get(3);
	
	
	
	if(name == null && mail == null && mail2 == null){
		str = "NO";
		out.write(str);
	}else if(name.equals(inputName) && mail.equals(inputMail) && mail2.equals(inputMail2)){
		str = id;
		out.write(str);
	}
%>