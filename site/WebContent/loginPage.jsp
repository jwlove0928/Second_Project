<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" type="text/css" href="loginCss.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#logingo").click(function () {
			
			var d = $("#f").serialize();
			
			var loginid = $("#loginid").val(); //텍스트에서 입력한 값 변수에 저장
			var loginpw = $("#loginpw").val(); //텍스트에서 입력한 값 변수에 저장
			
			if(loginid == ""){ //아이디를 입력하지 않으면 입력하라는 경고메세지
				alert("아이디를 입력해주세요");
				$("#loginid").focus();
				return false;
			}
			
			if(loginpw == ""){ //비밀번호를 입력하지 않으면 입력하라는 경고 메세지
				alert("비밀번호를 입력해주세요");
				$("#loginpw").focus();
				return false;
			}
			$.ajax({ // ajax를 통해 아이디 값과 비밀번호가 맞을시 로그인 성공 여부 처리
				url : "login.jsp",
				data : d,
				success : function (result) {
					var data = result.trim();
					if(data == "아이디 혹은 비밀번호가 맞지않습니다."){
						alert("아이디 혹은 비밀번호가 맞지않습니다.");
						return false;
					}
					if(data == "로그인에 성공하셨습니다."){
						alert("로그인에 성공하셨습니다.");
					}
				} 
			});
		});
		
		var ss = "<%=(String)session.getAttribute("rememberId")%>" //세션값 가져오기
		var ss1 = "<%=(String)session.getAttribute("sessionId")%>" //세션값 가져오기
		alert(ss);
		alert(ss1);
		if(ss != "null"){
			alert("세션있다");
			$("#loginid").val(ss);
		}else{
			alert("세션없다");
		}
	});
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	function movigtest (){ //회원가입 창으로 이동
		window.location.href="test.html";
	}
	function movingfindId() { //아아디/비밀번호 찾기 창으로 이동
		window.location.href="Find_ID.html";
	}
</script>
</head>
<body>
	<form id="f">
	  <div id="top">
	   <h1 class="login">로그인</h1>
	   <div class="form">
	    <div class="form2">
	     <div class="form3">
	      <input type="text" name= "loginid" id="loginid" placeholder="아이디 입력">
	      <div class="clear"></div>
	      <input type="password" name ="loginpw" id="loginpw" placeholder="비밀번호 입력">
	     </div>
		 <input type="submit" id="logingo" value="로그인하기">
	     <div class="clear"></div>
	     <div class="form4">
	      <label><input type="checkbox" name = "IdcheckBox" value="1">아이디 저장</label> 
	      <label><input type="checkbox">보안접속</label>
	      <div class="clear"></div>
		  <label><input type="button" onclick="movigtest()" value="회원가입"></label> 
		  <label><input type="button" onclick="movingfindId()" value="아이디/비밀번호찾기"></label>
	     </div>
	    </div>
	   </div>
	  </div>
	 </form>
</body>
</html>