<%@page import="java.util.ArrayList"%>
<%@page import="site.membershipDTO"%>
<%@page import="site.membershipDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message = "";

	String inputId = request.getParameter("loginid");
	String inputPw = request.getParameter("loginpw");
	String[] getIdBox = request.getParameterValues("IdcheckBox");
	
	membershipDAO dao = new membershipDAO();
	ArrayList list = dao.login(inputId, inputPw);
	
	String id = (String)list.get(0);
	String pw = (String)list.get(1);
	String name = (String)list.get(2);
		
		if(inputId.equals(id) && inputPw.equals(pw)){
			message = "로그인에 성공하셨습니다.";
			out.write(message);
			session.setAttribute("sessionId", id);
			if(getIdBox == null){ //아이디 저장 체크 안한것.
				session.setAttribute("remember", "");
			}else{
				session.setAttribute("rememberId", id);
				session.setAttribute("rememberName", name);
			}
		}
		else{
			message = "아이디 혹은 비밀번호가 맞지않습니다.";
			out.write(message);
		}
%>