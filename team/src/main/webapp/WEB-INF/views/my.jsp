<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href ="<c:url value="/resources/css/my.css"></c:url>" rel = 'stylesheet'/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		//체크박스 전체 선택해제
		$('#ck_all').click(function(){
			if($("#ck_all").prop("checked")){
				$("input[type=checkbox]").prop("checked",true);
			}else{
				$("input[type=checkbox]").prop("checked",false);
			}
		});
		
	});
		function deleteValue(){
			var url ="deleteUser";
			var valueArr = new Array();
			var list = $("input[name='checkRow']");
			
			for(var i =0; i<list.length; i++){
				if(list[i].checked){
					valueArr.push(list[i].value);
				}
			}
			if(valueArr.length==0){
				alert("선택된 글이 없습니다.");
			}
			else{
				var chk = confirm("정말 삭제하시겠습니까?");
				if(chk){
					
				$.ajax({
					url : url,
					type : 'POST',
					traditional : true,
					data : {
						valueArr : valueArr
					},
					success: function(data){
						if(data=1){
							alert("삭제 성공"),
							location.replace("List")
						}
						else{
							alert("삭제 실패");
						}
					}
				});
				
				}else{
					alert("취소 되었습니다.")
					return false;
				}
			}
		}
		
</script>

</head>
<body>
<%@ include file="nav.jsp" %>
<section>
<%@ include file="aside.jsp" %>

<main>
	<h2>지금 누른 메뉴 제목</h2>
	<hr>
	<div>
		관심목록  <a href="<c:url value='List?aside=like&sort=u_birth' />">최신순</a> <a href="#">최신순</a> <a href="#">최신순</a>
	</div>
	<div class="check">
		<input type="checkbox" id ="ck_all">전체선택 <input type="button" onclick="deleteValue()" value="삭제하기">
	</div>
	<div>
		<ul>
			<c:forEach items="${userList }" var="list">
			<li class ="c1">
				<input type="checkbox" name="checkRow" value="${list.u_num }">
				 <a href="#"><img src="<c:url value="/resources/images/${list.u_profile }"></c:url>"/></a>
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