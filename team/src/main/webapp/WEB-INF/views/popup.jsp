<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="url" value="${pageContext.request.requestURI}"/>

<html>
<head>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"/>
    <title>Title</title>
</head>
<body>
<script>


    function selectItem(){


        // var resArr = new Array();


        // $("#resTb input[name='chk_res']:checked").each(function(index) {
        //     var organismID = $(this).val();
        //
        //     $tr = $("#tr_"+organismID);
        //     storeDto.id = $tr.find("input[name='id']").val();
        //     storeDto.address = $tr.find("input[name='address']").val();
        //     storeDto.storeName = $tr.find("input[name='storeName']").val();
        //     storeDto.lat = $tr.find("input[name='lat']").val();
        //     storeDto.lon = $tr.find("input[name='lon']").val();
        //
        //     resArr.push(storeDto);
        // });
        // window.opener.setResList(resArr);
        // // window.opener.pop(resArr);
        // window.close();
    }
</script>
<table id="example" class="display" style="width:100%">
    <thead>
    <tr>
        <th>번호</th>
        <th>가게이름</th>
        <th>주소</th>
        <th>좋아요 수</th>
        <th>버튼</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="storeDto" items="${store}">
            <tr>
                <td>${storeDto.id}</td>
                <td>${storeDto.storeName}</td>
                <td>${storeDto.address}</td>
                <td>${storeDto.good}</td>
                <td><input class="rebut" type="button" value="버튼" onclick="sumitbtn(${storeDto.id},'${storeDto.storeName}',${storeDto.lat},${storeDto.lon});"></td>
                <input name="lat" type="hidden" value="${storeDto.lat}">
                <input name="lon" type="hidden" value="${storeDto.lon}">
            </tr>
        </c:forEach>
        <c:if test="${fn:length(store) == 0}">
            <tr>
        <%-- <td colspan="5"><spring:message code="" text="조회결과가 없습니다." /></td>--%>
            </tr>
        </c:if>
    </tbody>
    <tfoot>
    </tfoot>
</table>

</body>
<script>
	var type = '${type}';
	var did = null;
	var sname = null;
	var lat = null;
	var lon = null;
	
	$(document).ready(function () {
	    $('#example').DataTable();
	});
    
	function sumitbtn(a,b,c,d){
		if(type == 's'){ 
			window.opener.document.getElementById('start_id').value=a;
			window.opener.document.getElementById('start_name').value=b;
			window.opener.document.getElementById('start_ny').value=c;
			window.opener.document.getElementById('start_nx').value=d;
		}
		
		else if(type == 'e'){
			window.opener.document.getElementById('end_id').value=a;
			window.opener.document.getElementById('end_name').value=b;
			window.opener.document.getElementById('end_ny').value=c;
			window.opener.document.getElementById('end_nx').value=d;
			
		}
		 window.close();
	 };
	

</script>
</html>
