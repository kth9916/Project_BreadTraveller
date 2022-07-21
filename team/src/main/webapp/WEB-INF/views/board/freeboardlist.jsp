<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href ="<c:url value="/resources/css/board/list.css"></c:url>" rel ='stylesheet'/>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<title>자유게시판</title>
</head>

<script>
	$(document).on('click','#btnWriteForm',function(e){
		e.preventDefault();
		
		location.href="${pageContext.request.contextPath}/freeboard/write.action";
	});
	
	function fn_contentView(f_no){
		var url = "${pageContext.request.contextPath}/freeboard/read.action";
		url = url + "?f_no="+f_no;
		location.href = url;
	}
	
	//페이지네이션 이전 버튼
	function fn_prev(page, range, rangeSize){
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		
		var url = "${pageContext.request.contextPath}/freeboard/list.action";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
	
	//페이지 번호 클릭
	function fn_pagination(page,range,rangeSize,searchType,keyword){
		var url = "${pageContext.request.contextPath}/freeboard/list.action";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
	
	//페이지네이션 다음 버튼
	function fn_next(page,range,rangeSize){
		var page = parseInt((range * rangeSize)) + 1;
		var range = parseInt(range) + 1;
		
		var url = "${pageContext.request.contextPath}/freeboard/list.action";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
	
</script>




<body>
	<%@ include file="../user/nav.jsp" %>
	
<article>
	<div class="container">
		<div class="table-responsive">
			<h2>자유게시판</h2>
			<table class="table table-striped table-sm">
				<colgroup>
					<col style="width:5%;"/>
					<col style="width:auto%;"/>
					<col style="width:15%;"/>
					<col style="width:10%;"/>
					<col style="width:10%;"/>
				</colgroup>
				
				<thead>
					<tr>
						<th>NO</th>
						<th>글제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty boardList }">
							<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="list" items="${ boardList}">
								<tr>
									<td><c:out value="${list.f_no }"/></td>
									<td>
										<a href="#" onClick="fn_contentView(<c:out value="${list.f_no}"/>)">
											<c:out value="${list.f_title}"/>
										</a>
									</td>
									<td><c:out value="${list.f_writer }"/></td>
									<td><c:out value="${list.f_hit }"/></td>
									<td><c:out value="${list.f_wdate }"/></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		
		<div>
			<button type="button" class="btn btn-primary" id="btnWriteForm">글쓰기</button>
		</div>
		
		
		<!-- 페이지네이션 -->
		<div id="paginationBox">		
			<ul class="pagination">
				<c:if test="${pagination.prev}">
					<li class="page-item">
						<a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a>
					</li>
				</c:if>
				
				<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
					<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> ">
						<a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a>
					</li>
				</c:forEach>	
										
				<c:if test="${pagination.next}">				
					<li class="page-item">
						<a class="page-link" href="#" onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')">Next</a>
					</li>			
				</c:if>		
			</ul>	
		</div>
		<!-- ---- -->
		
		
	</div>
</article>
</body>
</html>