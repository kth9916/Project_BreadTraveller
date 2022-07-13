<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@charset "UTF-8";
/*basic reset*/
* {
 			box-sizing: border-box;
            list-style: none;
            margin: 0;
            padding: 0;
}

html {
 
  /*Image only BG fallback*/
  /*background = gradient + image pattern combo*/
 /*임시 이미지 배경*/

/*  height: 100%;

  background:url("https://images.pexels.com/photos/1565982/pexels-photo-1565982.jpeg")no-repeat center center fixed;
  background-size:cover;
*/

}
section{
	display:flex;
	border: solid 1px black;
	    flex-direction: column;
	left
}
h2 {
text-align: center;
}

article{
	background-color: white;
	border: solid 1px black;
	display: flex;
    flex-direction: column;
    align-items: flex-start;
}
li{
	margin: 50px;
	display: block;
}
img{
	width: 160px;
	height: 160px;
}
input[type="text"] {
    border: none;
    border-bottom: groove;
}
ul{
	display: flex;
    flex-direction: row;
    flex-wrap: wrap;
}
.ul1{
	display: flex;
	border: 1px gray solid;
}
.ul2{
	display: flex;
}
.ul3{
	display: flex;
}
</style>
</head>
<body>
<%@ include file="nav.jsp" %>
<section>
	<h2>회원 정보 수정</h2>
	<br>
	<form>
	<article>
		<div class ="ul1">
		<img name="u_profile"  src="<c:url value="/resources/images/${user.u_profile}"></c:url>"/>
		<ul class = "ul2">
			<li>아이디 : <input type ="text" value="${user.u_id}" readonly> </li>
			<li>이름 : ${user.u_name}</li>
			<li>별명 : <input type ="text" value="${user.u_nick}"></li>
		</ul>
		<ul class = "ul3">
			<li>등급 : ${user.u_grade}</li>
			<li>포인트 : ${user.point}</li>
			<li>누적 포인트 : ${user.apoint}</li>
		</ul>
		</div>
		
		<ul>
			<li>생일 : <input type ="date" value="${user.u_birth}"></li>
			<li>성별 : 
			<select name="u_gender" >
		     	<option value ="">성별</option>
		     	<option value ="male">남자</option>
		     	<option value ="female">여자</option>
		     	<option value ="other">기타</option>
    		 </select>
    		 </li>
			<li>휴대전화 : ${user.u_phone}</li>
		</ul>
			<input type="hidden" name ="u_address" value ="">
		<ul>
			<li><input type="text" id="postcode" name="u_post" placeholder="우편번호" value="${user.u_post}" readonly ></li>
			<li><input class="post action-button" type="button" value="우편번호 찾기"onclick="sample6_execDaumPostcode()"></li>
			<li><input type="text" id="address" placeholder="주소" value="${user.u_address}" readonly style ="width: 300px"></li>
			<li><input type="text" id="detailAddress"  placeholder="상세주소" style ="width: 300px"></li>
		</ul>
			<input type="hidden" id="extraAddress" placeholder="참고항목" readonly>
		
		<ul>
			<li>비밀번호 : <button>비밀번호 변경</button></li>
			<li>이메일 : <button>이메일 변경</button></li>
			<li>질문 : ${user.question}</li>
			<li>답변 : ${user.answer}</li>
		</ul>
	
	</article>
	</form>
</section>
</body>
</html>