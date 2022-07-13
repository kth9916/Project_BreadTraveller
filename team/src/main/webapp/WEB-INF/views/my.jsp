<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href ="<c:url value="/resources/css/my.css"></c:url>" rel = 'stylesheet'/>
</head>
<body>
<%@ include file="nav.jsp" %>
<section>
<%@ include file="aside.jsp" %>

<main>
	<h2>지금 누른 메뉴 제목</h2>
	<hr>
	<div>
		관심목록  <a href="#">최신순</a> <a href="#">최신순</a> <a href="#">최신순</a>
	</div>
	<div class="check">
		<input type="checkbox">전체선택 <button>삭제</button>
	</div>
	<div>
		<ul>
			<c:forEach items="${userList }" var="list">
			<li class ="c1">
				<input type="checkbox"> <a href="#"><img src="<c:url value="/resources/images/${list.u_profile }"></c:url>"/></a>
				 <span class="s2">${list.u_name }</span>
				 <span class="s2">${list.u_email }</span>
			</li>
			<li>
				<a href="#">#빵집의 대표빵?(누르면 이거 목록만 get으로 정렬)</a>
			</li>
			</c:forEach>
		</ul>
	
	</div>
</main>
</section>
</body>
</html>