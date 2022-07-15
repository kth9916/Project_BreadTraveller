<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href ="<c:url value="/resources/css/nav.css"></c:url>" rel ='stylesheet'/>

<script src="https://kit.fontawesome.com/628c8d2499.js" crossorigin="anonymous"></script>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
</head>

<div class="header1">
	<nav id="log">
	  
	  
		  <%
	  	String u_id = null;
	  if(session.getAttribute("u_id") != null){
		  u_id = (String) session.getAttribute("u_id");
	  }
	%>
	
	<%
		if(u_id == null){
	%>
	
	<div class="menu-item2">
    <div class="menu-text">
      <a href="login">로그인</a>
    </div>
   </div>
   	<div class="menu-item2">
    <div class="menu-text">
      <a href="register">회원가입</a>
    </div>
   </div>

	<%
		}else{
	%>
	
	<div class="menu-item2">
    <div class="menu-text" style="width:170px;">
      <%=u_id %>님 환영합니다
    </div>
   </div>
   	<div class="menu-item2">
    <div class="menu-text">
    <a href="<c:url value='List' />">마이</a>
      <a href="<c:url value='logout' />">로그아웃</a>
    </div>
   </div>
	
	
	
	<%} %>
	
	
	</nav>
	<div class="logo"><a href="<c:url value='/' />"><img alt="" src="<c:url value="/resources/images/icon.png" ></c:url>" style="width:60px;height:60px;"></a></div>
	<nav id="menu">

	  <div class="menu-item">

	    <div class="menu-text">
	      <a href="#">Products</a>
	    </div>
	    <div class="sub-menu">
	      <div class="icon-box">
	        <div class="icon"><i class="fal fa-wind-turbine"></i></div>
	        <div class="text">
	          <div class="title">Turbo Editor <i class="far fa-arrow-right"></i></div>
	          <div class="sub-text">Edit your code while slowing down time.</div>
	        </div>
	      </div>
	      <div class="icon-box">
	        <div class="icon"><i class="fal fa-lightbulb-on"></i></div>
	        <div class="text">
	          <div class="title">Idea Creator <i class="far fa-arrow-right"></i></div>
	          <div class="sub-text">Think of an idea, and have an AI create it.</div>
	        </div>
	      </div>
	      <div class="icon-box">
	        <div class="icon"><i class="fal fa-bomb"></i></div>
	        <div class="text">
	          <div class="title">Super Collider <i class="far fa-arrow-right"></i></div>
	          <div class="sub-text">Remove mass from any object.</div>
	        </div>
	      </div>
	      <div class="sub-menu-holder"></div>
	    </div>
	  </div>
	  <div class="menu-item highlight">
	    <div class="menu-text">
	      <a href="#">Services</a>
	    </div>
	    <div class="sub-menu double">
	      <div class="icon-box gb a">
	        <div class="icon"><i class="far fa-question-circle"></i></div>
	        <div class="text">
	          <div class="title">Consult <i class="far fa-arrow-right"></i></div>
	          <div class="sub-text">From Professionals</div>
	        </div>
	      </div>
	      <div class="icon-box gb b">
	        <div class="icon"><i class="far fa-users-class"></i></div>
	        <div class="text">
	          <div class="title">Teach <i class="far fa-arrow-right"></i></div>
	          <div class="sub-text">In Classroom</div>
	        </div>
	      </div>
	      <div class="icon-box gb c">
	        <div class="icon"><i class="far fa-school"></i></div>
	        <div class="text">
	          <div class="title">Learn <i class="far fa-arrow-right"></i></div>
	          <div class="sub-text">By Video</div>
	        </div>
	      </div>
	      <div class="icon-box gb d">
	        <div class="icon"><i class="far fa-chess-rook"></i></div>
	        <div class="text">
	          <div class="title">Keep <i class="far fa-arrow-right"></i></div>
	          <div class="sub-text">The Castle</div>
	        </div>
	      </div>
	      <div class="icon-box gb e">
	        <div class="icon"><i class="far fa-video-plus"></i></div>
	        <div class="text">
	          <div class="title">Become <i class="far fa-arrow-right"></i></div>
	          <div class="sub-text">A Creator</div>
	        </div>
	      </div>
	      <div class="icon-box gb f">
	        <div class="icon"><i class="far fa-cat"></i></div>
	        <div class="text">
	          <div class="title">Understand <i class="far fa-arrow-right"></i></div>
	          <div class="sub-text">Our Journey</div>
	        </div>
	      </div>
	      <div class="bottom-container">
	        Ready to dive in? <a href="#">Get Started</a>
	      </div>
	      <div class="sub-menu-holder"></div>
	    </div>
	  </div>
	  <div class="menu-item highlight">
	    <div class="menu-text">
	      <a href="#">Support</a>
	    </div>
	    <div class="sub-menu triple">
	      <div class="top-container gb c icon-box">
	        <div class="icon big"><i class="far fa-book"></i></div>
	        <div class="text">
	          <div class="title">Where to start</div>
	          <div class="sub-text">Find out where to begin below</div>
	        </div>
	      </div>
	      <div class="box">
	        <h3>Your Journey</h3>
	        <a href="#">Get Started</a>
	        <a href="#">Learn the Basics</a>
	        <a href="#">Get Advanced</a>
	        <a href="#">Start Teaching</a>
	      </div>
	      <div class="box">
	        <h3>Your Tools</h3>
	        <a href="#">Turbo Editor</a>
	        <a href="#">Time Stopper</a>
	        <a href="#">Brain Enhancer</a>
	        <a href="#">Network Maker</a>
	      </div>
	      <div class="icon-box flat">
	        <div class="icon"><i class="fal fa-plug"></i></div>
	        <div class="text">
	          <div class="title">API Guide <i class="far fa-arrow-right"></i></div>
	        </div>
	      </div>
	      <div class="icon-box flat">
	        <div class="icon"><i class="fal fa-comments"></i></div>
	        <div class="text">
	          <div class="title">Support Line <i class="far fa-arrow-right"></i></div>
	        </div>
	      </div>
	      <div class="icon-box flat">
	        <div class="icon"><i class="fal fa-phone-volume"></i></div>
	        <div class="text">
	          <div class="title">Live Chat <i class="far fa-arrow-right"></i></div>
	        </div>
	      </div>
	      <div class="icon-box flat">
	        <div class="icon"><i class="fal fa-book-spells"></i></div>
	        <div class="text">
	          <div class="title">Documentation <i class="far fa-arrow-right"></i></div>
	        </div>
	      </div>
	    </div>
	  </div>
	  <div class="menu-item">
	    <div class="menu-text">
	      <a href="#">Community</a>
	    </div>
	    <div class="sub-menu">
	      <div class="icon-box">
	        <div class="icon"><i class="far fa-satellite"></i></div>
	        <div class="text">
	          <div class="title">Forum <i class="far fa-arrow-right"></i></div>
	          <div class="sub-text">Join our passionate community.</div>
	        </div>
	      </div>
	      <div class="icon-box">
	        <div class="icon"><i class="fab fa-twitter-square"></i></div>
	        <div class="text">
	          <div class="title">Twitter <i class="far fa-arrow-right"></i></div>
	          <div class="sub-text">Follow us on twitter.</div>
	        </div>
	      </div>
	      <div class="icon-box">
	        <div class="icon"><i class="fab fa-twitch"></i></div>
	        <div class="text">
	          <div class="title">Live Stream <i class="far fa-arrow-right"></i></div>
	          <div class="sub-text">We stream content every day.</div>
	        </div>
	      </div>
	      <div class="sub-menu-holder"></div>
	    </div>
	  </div>
	  <div id="sub-menu-container">
	    <div id="sub-menu-holder">
	      <div id="sub-menu-bottom">
	
	      </div>
	    </div>
	  </div>

	  
	  
	</nav>

</div>
