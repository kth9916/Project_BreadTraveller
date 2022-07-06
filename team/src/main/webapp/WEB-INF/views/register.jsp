<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<!-- multistep form -->
<<<<<<< HEAD
<form id="msform" action="<c:url value="/user/register" />" method="post">
  <!-- progressbar -->
  <ul id="progressbar">
    <li class="active">Account Setup</li>
    <li>Social Profiles</li>
    <li>Personal Details</li>
  </ul>
  <!-- fieldsets -->
  <fieldset>
    <h2 class="fs-title">회원 가입</h2>
    <h3 class="fs-subtitle">STEP 1</h3>
    <input type="text" name="u_name" placeholder="Name" />
    <input type="text" name="u_id" placeholder="ID" />
    <input type="password" name="u_pass" placeholder="Password" autoComplete="off"/>
    <input type="password" name="cpass" placeholder="Confirm Password" autoComplete="off"/>
    <input type="button" name="next" class="next action-button" value="Next" />
  </fieldset>
  <fieldset>
    <h2 class="fs-title">Social Profiles</h2>
    <h3 class="fs-subtitle">Your presence on the social network</h3>
    <input type="text" name="u_nick" placeholder="NickName" />
    <input type="radio" name ="u_gender" id="male" style="display: inline;">
    <label for="male">남자</label>
    <input type="radio" name ="u_gender" id="female">
    <label for="female">여자</label>
    <input type ="date" name = "u_birth" placeholder="bitrh">
    <input type="text" name="u_post" placeholder="Post" />
    <input type="text" name="u_address" placeholder="Address" />
    <input type="button" name="previous" class="previous action-button" value="Previous" />
    <input type="button" name="next" class="next action-button" value="Next" />
  </fieldset>
  <fieldset>
    <h2 class="fs-title">Personal Details</h2>
    <h3 class="fs-subtitle">We will never sell it</h3>
    <input type="text" name="u_phone" placeholder="Phone" />
    <input type="text" name="u_email" placeholder="Email" class ="mail_input"/>
    <div class="mail_check_input_box" id ="mail_check_input_hox_false">
    <input class ="mail_check_input" disabled="disabled" />
    </div>
    <div>
    <button type ="button" name="email3" class="mail_check_button">인증번호 전송</button>
    </div>
    <input type="text" name="question" placeholder="Question" />
    <input type="text" name="answer" placeholder="Answer" />
    <input type="button" name="previous" class="previous action-button" value="Previous" />
   <!-- 
    <button type ="button" name ="submit" class="submit action-button">Submit</button>
    -->
    <input type ="submit" class="submit action-button" value ="SubmitInput" id ="submit"> 
  </fieldset>
=======

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
    <input type="text" name="u_name" placeholder="이름" />
    <input type="text" name="u_id" placeholder="아이디" />
    <input type="password" name="u_pass" placeholder="비밀번호" autoComplete="off"/>
    <input type="password" name="cpass" placeholder="비밀번호 확인" autoComplete="off"/>
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
  
>>>>>>> gyh
</form>





<script src="<c:url value ="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></c:url>"></script>
<script src="<c:url value ="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></c:url>"></script>

<<<<<<< HEAD
<!-- 
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/common/browser_support-e442aebd85f2bb9dcd4a47cb43c7fc38efd5522ace0a675bf5e33a06413b5a28.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/packs/js/vendor-15f804772bfcbed2d0fe.chunk.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/packs/js/1-6acfa3e74c470bf248a7.chunk.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/packs/js/everypage-8f6342702dcbff1e4d15.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/common/analytics_and_notifications-49dbf9eb3e832169ceaad20dab2e210aae9832821d457c2dbb846d10d04243c6.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/packs/js/vendor-15f804772bfcbed2d0fe.chunk.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/packs/js/1-6acfa3e74c470bf248a7.chunk.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/packs/js/referrer-tracking-1d5843d46337423abecd.js"></c:url>"></script>


<script src="<c:url value ="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></c:url>"></script>
 -->

<link href ="<c:url value="/resources/css/test2.css"></c:url>" rel = 'stylesheet'/>

=======
<link href ="<c:url value="/resources/css/test2.css"></c:url>" rel = 'stylesheet'/>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
>>>>>>> gyh
<script src ="<c:url value="/resources/js/test2.js"></c:url>"></script>


</body>
</html>