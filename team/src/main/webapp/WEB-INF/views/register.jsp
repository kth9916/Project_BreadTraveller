<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<!-- multistep form -->
<form id="msform">
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
    <input type="text" name="u_id" placeholder="Email" />
    <input type="password" name="pass" placeholder="Password" />
    <input type="password" name="cpass" placeholder="Confirm Password" />
    <input type="button" name="next" class="next action-button" value="Next" />
  </fieldset>
  <fieldset>
    <h2 class="fs-title">Social Profiles</h2>
    <h3 class="fs-subtitle">Your presence on the social network</h3>
    <input type="text" name="twitter" placeholder="Twitter" />
    <input type="text" name="facebook" placeholder="Facebook" />
    <input type="text" name="gplus" placeholder="Google Plus" />
    <input type="button" name="previous" class="previous action-button" value="Previous" />
    <input type="button" name="next" class="next action-button" value="Next" />
  </fieldset>
  <fieldset>
    <h2 class="fs-title">Personal Details</h2>
    <h3 class="fs-subtitle">We will never sell it</h3>
    <input type="text" name="fname" placeholder="First Name" />
    <input type="text" name="lname" placeholder="Last Name" />
    <input type="text" name="phone" placeholder="Phone" />
    <textarea name="address" placeholder="Address"></textarea>
    <input type="button" name="previous" class="previous action-button" value="Previous" />
    <input type="submit" name="submit" class="submit action-button" value="Submit" />
  </fieldset>
</form>





<script src="<c:url value ="https://cpwebassets.codepen.io/assets/common/browser_support-e442aebd85f2bb9dcd4a47cb43c7fc38efd5522ace0a675bf5e33a06413b5a28.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/packs/js/vendor-15f804772bfcbed2d0fe.chunk.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/packs/js/1-6acfa3e74c470bf248a7.chunk.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/packs/js/everypage-8f6342702dcbff1e4d15.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/common/analytics_and_notifications-49dbf9eb3e832169ceaad20dab2e210aae9832821d457c2dbb846d10d04243c6.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/packs/js/vendor-15f804772bfcbed2d0fe.chunk.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/packs/js/1-6acfa3e74c470bf248a7.chunk.js"></c:url>"></script>
<script src="<c:url value ="https://cpwebassets.codepen.io/assets/packs/js/referrer-tracking-1d5843d46337423abecd.js"></c:url>"></script>

<script src="<c:url value ="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></c:url>"></script>

<link href ="<c:url value="/resources/css/test2.css"></c:url>" rel = 'stylesheet'/>

<script src ="<c:url value="/resources/js/test2.js"></c:url>"></script>


</body>
</html>