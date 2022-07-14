<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href ="<c:url value="/resources/css/login.css"></c:url>" rel ='stylesheet'/>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.transit/0.9.12/jquery.transit.js" integrity="sha256-mkdmXjMvBcpAyyFNCVdbwg4v+ycJho65QLDwVE3ViDs=" crossorigin="anonymous"></script>
<script type="text/javascript">

//JQUERY
$(function () {
	var images = [
		"https://images.pexels.com/photos/1565982/pexels-photo-1565982.jpeg",
		"https://images.pexels.com/photos/1565982/pexels-photo-1565982.jpeg"
	];

	$("#container").append(
		"<style>#container, .acceptContainer:before, #logoContainer:before {background: url(" +
			images[Math.floor(Math.random() * images.length)] +
			") center fixed }"
	);

	setTimeout(function () {
		$(".logoContainer").transition({ scale: 1 }, 50, "ease-in");
		setTimeout(function () {
			$(".logoContainer .logo").addClass("loadIn");
			setTimeout(function () {
				$(".logoContainer .text").addClass("loadIn");
				setTimeout(function () {
					$(".acceptContainer").transition({ height: "531.5px", width: "600px" });
					setTimeout(function () {
						$(".acceptContainer").addClass("loadIn");
						setTimeout(function () {
							$(".formDiv, form h1").addClass("loadIn");
						}, 700, "ease");
					}, 600, "ease");
				}, 500, "ease");
			}, 400);
		},  "ease-in");
	}, 10);
});

</script>
<body>

<%@ include file="nav.jsp" %>

<!-- NORMALIZED CSS INSTALLED-->
<!-- View settings for more info.-->
<div id="container">

  <div id="inviteContainer">
    <div class="logoContainer"><img class="text" src="<c:url value="/resources/images/breadLogo.png"></c:url>"/></div>
    <div class="acceptContainer">
      <form action="<c:url value="/user/login" />" method="post" onsubmit="return formCheck(this);">
        <h1>어서 오세요!</h1>
        <div id="msg">
            <c:if test="${not empty msg}">
                <i class="fa fa-exclamation-circle"> ${msg}</i>
            </c:if>
        </div>  
        <div class="formContainer">
          <div class="formDiv" style="transition-delay: 0.2s">
            <p>ID</p>
            <input type="text" name="u_id" value="${cookie.u_id.value }" autofocus required/>
            <label><input type="checkbox" name="rememberId" value="on" ${empty cookie.u_id.value ? "":"checked"}> 아이디 기억</label>
          </div>
          <div class="formDiv" style="transition-delay: 0.4s">
            <p>PASSWSORD</p>
            <input type="password" name="u_pass" required/><a class="forgotPas" href="<c:url value='user/forgotPas' />">FORGOT YOUR PASSWORD?</a>
            <input type="hidden" name="toURL" value="${param.toURL }">
          </div>
          <div class="formDiv" style="transition-delay: 0.6s">
            <button class="acceptBtn" type="submit">Login</button>
            <span class="register">Need an account?<a href="<c:url value='/user/register' />">Register</a></span>
          </div>
        </div>
   
      </form>
    </div>
  </div>
</div>
</body>
</html>