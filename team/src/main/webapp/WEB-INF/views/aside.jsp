<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<aside>
	<div class="nav">
		<div class="pro">
			<ul>
				<li><img name="u_profile"  src="<c:url value="/resources/images/${user.u_profile}"></c:url>"/></li>
				<li >${user.u_id}</li>
				<li ><fmt:formatDate value="${user.u_date}" pattern="yyyy-MM-dd" type="date"/></li>
				<li >${user.point}</li>
				<li ><input type="button" value="회원 정보 수정" onclick="location.href='update'"></li>
			</ul>
		</div>
		<div>
			<span class="s1"><a href="<c:url value='List?aside=bread&sort=u_num' />">관심목록</a></span>
		</div>	
		<div>
			<span class="s1"><a href="<c:url value='List?aside=bread&sort=' />">활동내역</a></span>
			<ul>
				<li><a href="<c:url value='List?aside=like&sort=u_date' />">좋아요한 게시물</a></li>
				<li><a href="<c:url value='List?aside=bread&sort=' />">내가 쓴 글</a></li>
				<li><a href="<c:url value='List?aside=bread&sort=' />">내 QNA</a></li>
			</ul>
		</div>
	</div>
</aside>
</body>
</html>