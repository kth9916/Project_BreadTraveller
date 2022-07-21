<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!-- summernote -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  
  
  
  
<title>글쓰기</title>

<script>
	$(document).on('click','#btnSave',function(e){
		e.preventDefault();
		$("#form").submit();
	});
	
	$(document).on('click','#btnList',function(e){
		e.preventDefault();
		location.href="${pageContext.request.contextPath}/freeboard/list.action"
	});
	
	$(document).ready(function(){
		var mode = '<c:out value="${mode}"/>';
		if(mode=='edit'){
			//입력 폼 세팅
			$("#f_writer").prop('readonly',true);
			$("input:hidden[name='f_no']").val(<c:out value="${boardContent.f_no}"/>);
			$("input:hidden[name='mode']").val('<c:out value="${mode}"/>');
			$("#f_writer").val('<c:out value="${boardContent.f_writer}"/>');
			$("#f_title").val('<c:out value="${boardContent.f_title}"/>');
			$("#f_content").val('<c:out value="${boardContent.f_content}"/>');
		}
	});
	
</script>


</head>
<body>
	<%@ include file="../user/nav.jsp" %>

<article>
	<div class="container" role="main">
		<h2>자유게시판 글쓰기</h2>
		<form:form name="form" id="form" role="form" modelAttribute="freeBoardVO" method="post" action="${pageContext.request.contextPath}/freeboard/updatesave.action">
			<form:hidden path="f_no" />
			<input type="hidden" name="mode"/>
			<div class="mb-3">
				<label for="f_title">제목</label>
				<form:input path="f_title" type="text" class="form-control" name="f_title" id="f_title" placeholder="제목을 입력해 주세요"/>
			</div>
			<div class="mb-3">
				<label for="f_writer">작성자</label>
				<form:input path="f_writer" type="text" class="form-control" name="f_writer" id="f_writer" placeholder="작성자이름"/>
			</div>
			<div class="mb-3">
				<label for="f_content">본문내용</label>
				<form:textarea path="f_content" name="content" id="summernote" class="summernote"/>
			</div>
		</form:form>
		
		<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>				
		<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
		
	</div>
</article>



<script>
$(document).ready(function() {
  $('#summernote').summernote({
	  height: 300,
	  minHeight: null,
	  maxHeight: 1000,
	  focus: true
  });
});

</script>
</body>
</html>