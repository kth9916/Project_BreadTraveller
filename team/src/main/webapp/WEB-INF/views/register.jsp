<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>



<link href ="<c:url value="/resources/css/test2.css"></c:url>" rel = 'stylesheet'/>


</head>

<!-- multistep form -->

<form id="msform" action="<c:url value="/user/register" />" method="post">
  
  <!-- progressbar -->
  
  <ul id="progressbar">
    <li class="active">STEP 1</li>
    <li>STEP 2</li>
    <li>STEP 3</li>
  </ul>
  
  <!-- fieldsets -->
  
  <fieldset>
    <h2 class="fs-title">회원 가입</h2>
    <h3 class="fs-subtitle">STEP 1</h3>
    <input type="text" name="u_name" id ="u_name" placeholder="이름" />
    <input type="text" name="u_id" id ="u_id" placeholder="아이디" />
    <input type="button" name="idck" class="idck action-button" value="아이디 중복확인" />
    <input type="password" name="u_pass" id="u_pass" placeholder="비밀번호" autoComplete="off"/>
    <input type="password" name="cpass" id="cpass" placeholder="비밀번호 확인" autoComplete="off"/>
    <input type="button" name="next" class="next action-button" value="다음" />
  </fieldset>
  
  <fieldset>
    <h2 class="fs-title">필수 정보</h2>
    <h3 class="fs-subtitle">STEP 2</h3>
    <input type="text" name="u_nick" placeholder="닉네임" />
    <input type ="date" name = "u_birth" placeholder="생일">
    <input type="text" name="u_phone" placeholder="전화번호" />
	<input type="text" name="u_email" placeholder="이메일" class ="mail_input"/>
       	<div class="mail_check_input_box" id ="mail_check_input_hox_false">
   			<input type="text" class ="mail_check_input" disabled="disabled" placeholder="인증번호" />
   		</div>
   			<span id ="mail_check_input_box_warn"></span>
   		<div>
   			<input type ="button" style ="width:250px"id ="email3" name="email3" class="email3 action-button" value ="인증번호 전송"/>
   		</div>
    <input type="text" name="question" placeholder="회원가입 질문" />
    <input type="text" name="answer" placeholder="답변" />
    <input type="button" name="previous" class="previous action-button" value="이전" />
    <input type="button" name="next" class="next action-button" value="다음" />
  </fieldset>
  
  <fieldset style ="
    margin-left: 24px !important;" >
    <h2 class="fs-title">선택 정보</h2>
    <h3 class="fs-subtitle">STEP 3</h3>
    <select name="u_gender" >
     	<option value ="">성별</option>
     	<option value ="male">남자</option>
     	<option value ="female">여자</option>
     	<option value ="other">기타</option>
     </select>
     <div>
         <input type="text" id="postcode" name="u_post" placeholder="우편번호" readonly >
         <input class="post action-button" type="button" value="우편번호 찾기"onclick="sample6_execDaumPostcode()">
     </div>
     	 <input type="hidden" name ="u_address" value ="">
     <div>
         <input type="text" id="address" placeholder="주소" readonly style ="width: 300px">
     </div>
     <div>
         <input type="text" id="detailAddress"  placeholder="상세주소" style ="width: 300px">
     </div>   
     <div>
         <input type="text" id="extraAddress" placeholder="참고항목" readonly>
     </div>   
    <input type="button" name="previous" class="previous action-button" value="이전" />
    <input type ="submit" class="submit action-button" value ="회원가입" id ="submit"> 
  </fieldset>
  
</form>

<script src="<c:url value ="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></c:url>"></script>
<script src="<c:url value ="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></c:url>"></script>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src ="<c:url value="/resources/js/test2.js"></c:url>"></script>



</body>
</html>