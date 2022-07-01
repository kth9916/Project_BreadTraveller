<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<link href ="<c:url value="/resources/css/test.css"></c:url>" rel ='stylesheet'/>
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


<!-- NORMALIZED CSS INSTALLED-->
<!-- View settings for more info.-->
<div id="container">
  <div id="inviteContainer">
    <div class="logoContainer"><img class="text" src="<c:url value="/resources/breadLogo.png"></c:url>"/></div>
    <div class="acceptContainer">
      <form action ="/user/login" method ="post">
        <h1>WELCOME BACK!</h1>
        <div class="formContainer">
          <div class="formDiv" style="transition-delay: 0.2s">
            <p>ID</p>
            <input type="text" name="u_id" required/>
          </div>
          <div class="formDiv" style="transition-delay: 0.4s">
            <p>PASSWSORD</p>
            <input type="password" name ="u_pass" required/><a class="forgotPas" href="#">FORGOT YOUR PASSWORD?</a>
          </div>
          <div class="formDiv" style="transition-delay: 0.6s">
            <button class="acceptBtn" type="submit">Login</button><span class="register">Need an account?<a href="#">Register</a></span>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>



</body>
</html>