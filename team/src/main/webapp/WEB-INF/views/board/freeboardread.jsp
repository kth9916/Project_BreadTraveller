<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<link href ="<c:url value="/resources/css/board/common.css"></c:url>" rel ='stylesheet'/>
<meta charset="EUC-KR">
<title>${boardContent.f_no}번 게시물</title>

<script>
	
	//게시판 목록
	$(document).on('click','#btnList',function(){
		location.href="${pageContext.request.contextPath}/freeboard/list.action";
	});
	
	//수정
	$(document).on('click','#btnUpdate',function(){
		var url = "${pageContext.request.contextPath}/freeboard/update.action";
		url = url + "?f_no="+${boardContent.f_no};
		url = url + "&mode=edit";
		
		location.href = url;
	});
	
	//삭제
	$(document).on('click','#btnDelete',function(){
			var url = "${pageContext.request.contextPath}/freeboard/delete.action";
			url = url + "?f_no="+${boardContent.f_no};
			location.href=url;
	});
	
</script>

</head>
<body>
	<article>		
		<div class="container" role="main">			
		<h2>board Content</h2>						
			<div class="bg-white rounded shadow-sm">		
				<div class="board_title"><c:out value="${boardContent.f_title}"/></div>
				<div class="board_info_box">
					<span class="board_author"><c:out value="${boardContent.f_writer}"/>,</span>
					<span class="board_date"><c:out value="${boardContent.f_wdate}"/></span>				
				</div>				
				<div class="board_content">${boardContent.f_content}</div>				
			</div>						
			<div style="margin-top : 20px">				
				<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>				
				<button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>				
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>			
			</div>		
		</div>			
	</article>
	
</body>
</html>