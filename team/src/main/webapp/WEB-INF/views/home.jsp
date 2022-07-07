<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
	 <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
  
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="login">로그인 페이지 이동</a>
<a href="register">회원가입 페이지 이동</a>
<a href="<c:url value='/user/login' />">로그아웃</a>
<a href="main">메인</a>

<!-- 네이버 로그인 버튼 노출 영역 -->
  <div id="naver_id_login"></div>
  <!-- //네이버 로그인 버튼 노출 영역 -->
 
	<script type="text/javascript">
  	var naver_id_login = new naver_id_login("aa", "http://localhost:9392/team/callback");
  	var state = naver_id_login.getUniqState();
  	naver_id_login.setButton("white", 2,40);
  	naver_id_login.setState(state);
  	naver_id_login.setPopup();
  	naver_id_login.init_naver_id_login();
  	
  </script>

</body>
</html>
