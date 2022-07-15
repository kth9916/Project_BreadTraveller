<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<title>글쓰기</title>
</head>
<body>
	<%@ include file="../nav.jsp" %>

<form action="<c:url value="write/submit" />" method="post">
<textarea name="content" id="summernote" class="summernote"></textarea>
<input type="submit">
</form>





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