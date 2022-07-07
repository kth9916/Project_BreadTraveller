<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>간편 가입</title>
  <link href ="<c:url value="/resources/css/test.css"></c:url>" rel = 'stylesheet'/>
</head>
<body>
<form id="msform" action="<c:url value="/user/naver" />" method="post">
<fieldset >
    <h2 class="fs-title">간편 가입</h2>
    <h3 class="fs-subtitle">네이버</h3>
    <input type="text" name="question" id ="question" placeholder="회원가입 질문" />
    <input type="text" name="answer" id = "answer" placeholder="답변" />
    <input type="button" name="previous" class="previous action-button" value="이전" />
    <input type ="submit" class="submit action-button" value ="회원가입" id ="submit"> 
  </fieldset>
</form>	
<script src="<c:url value ="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></c:url>"></script>
<script src="<c:url value ="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></c:url>"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src ="<c:url value="/resources/js/test.js"></c:url>"></script>

</body>
</html>